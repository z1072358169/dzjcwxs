app.filter('data_typea', function() { //可以注入依赖
    return function(text) {
        switch(text){
            case 1:return "未机筛";
            case 2:return "机筛";
        };
    }
});
app.filter('data_sfsh', function() { //可以注入依赖
    return function(text) {
        switch(text){
            case "-1":return "未审核";
            case "0":return "已通过";
            case "1":return "已作废";
        };
    }
});
//废片筛选
app.controller('ScrapScreenCtrl', function($scope, $http, $rootScope,$cookieStore) {
	$scope.person = $cookieStore.get("person");
    $cookieStore.remove("csidlist");
	if ($scope.person == null || $scope.person == ""){
		$cookieStore.remove("person");
		window.location = "index.html";
	};
	$scope.data_cc = "";//号牌区
	$scope.data_c = "";//号牌码
    $scope.pageSizea = 0;//待筛选总数
    $scope.fpdataobj = {firstPage: 0,list:[],navigatepageNums: [],nextPage: 0,pageNum: 0,pageSize: 0,pages: 0,prePage: 0,size: 0,startRow: 0,total: 0};
    $scope.page_size = null;//判断是否提取数据
    $scope.cqzs = "200";//每页显示多少条
    $scope.pagesizefp = "50";//提取数量
    function today(){
	    var today=new Date();
	    var h=today.getFullYear();
	    var m=today.getMonth()+1;
	    var d=today.getDate();
	    var hh=today.getHours();
	    var mm=today.getMinutes();
	    var ss=today.getSeconds();
	    m= m<10?"0"+m:m;     
	    d= d<10?"0"+d:d;
	    hh = hh < 10 ? "0" + hh:hh;
	    mm = mm < 10 ? "0" + mm:mm;
	    ss = ss < 10 ? "0" + ss:ss;
	    return h+"-"+m+"-"+d;
	};
	function today2(da){
		var curDate = new Date();
	    var today=new Date(curDate.getTime() - da*24*60*60*1000);
	    var h=today.getFullYear();
	    var m=today.getMonth()+1;
	    var d=today.getDate();
	    m= m<10?"0"+m:m;     
	    d= d<10?"0"+d:d;
	    return h+"-"+m+"-"+d;
	};
	$("#starttime").val(today2(1)+" "+ "00:00:00");
	$("#endtime").val(today2(1)+" "+ "23:59:59");


    //查询条件列表
    $scope.example = function(){
        $http({
            method : 'get',
            // url : GserverURL + "findAddress.action",
            url : GserverURL + "findAddressfz.action",
        }).success(function(data) {
            var renyuan1 = data;
            $("#exampledata1").selectpicker({
                noneSelectedText : '请选择'//默认显示内容
            });
            $(window).on('load', function() {
                $('#exampledata1').selectpicker('val', '');
                $('#exampledata1').selectpicker('refresh');
            });
            var select = $("#exampledata1");
            select.append("<option value=''>请选择</option>");
            angular.forEach(renyuan1, function(data, index) {
                select.append("<option value='"+data.CJDZ+"'>"  + data.CJDZ + "</option>");
                if(index==renyuan1.length-1){
                    $('#exampledata1').selectpicker('val', '');
                    $('#exampledata1').selectpicker('refresh');
                }
            });

        }).error(function() {
        });
    };
    $http({
        method : 'get',
        url : GserverURL + "queryAll.action"
    }).success(function(data) {
        $scope.params = data[0];
        $scope.example();
    }).error(function() {
        $scope.popup1('无法连接到服务器');
    });

	//统计数量
	$scope.tongjisladata = {};
    $scope.tongjisla = function(){
    	$http({
            method : 'get',
            // url : GserverURL + "finduserandcount2.action",
            url : GserverURL + "finduserandcount2fz.action",
            params:{
            	startTime:today()+" "+ "00:00:00",//时间
            	endTime:today()+" "+ "23:59:59",//时间
            	userName:$scope.person.userName//筛选人
            }
        }).success(function(data) {
        	if(data.tj1==undefined){
        		$scope.tongjisladata1 = {
        				pass:0,
        				tovoid:0
        		};
        	}else{
        		$scope.tongjisladata1 = data.tj1;
        	}
        	$scope.tongjisladata2 = data.tj2;
            $scope.tongjisladata3 = data.tj3;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };

    //数据总数
    $scope.chaxunztsa = function(){
        $scope.lopopup();
        $http({
            method : 'get',
            // url : GserverURL + "getCountfpName.action",
            url : GserverURL + "findPageByfz.action",
            params:{
            	userName:"",
            	HPZL:$scope.data_a,//号牌种类
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//违法行为
                CSMZ:$scope.data_f,//厂商名字
                SFSH:-1//初筛 0:通过，1:作废。默认-1
            }
        }).success(function(data) {
            //console.log(data.total);
        	$scope.pageSizea = data.total;
            $scope.chaxun(1);
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    //查询数据
    $scope.chaxun = function(d){
        $scope.lopopup();
        $http({
            method : 'get',
            // url : GserverURL + "findPageBy.action",
            url : GserverURL + "findPageByfz.action",
            params:{
                userName:$scope.person.userName,
                HPZL:$scope.data_a,//号牌种类
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//违法行为
                CSMZ:$scope.data_f,//厂商名字
                SFSH:-1,
                pageNo:d,//第几页
                pageSize:$scope.cqzs
            }
        }).success(function(data) {
            layer.closeAll('loading');
            $scope.page_size = data.list.length;
            $scope.fpdataobj = data;
            $cookieStore.remove("csidlist");
            $scope.tongjisla();
            //$scope.fengyez(data);
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunztsa();
    //分配数据
    $scope.fenpeidata = function(){
        $scope.lopopup();
    	//var userna = JSON.parse($scope.userName);
        if(Number($scope.pagesizefp)>200){
            //layer.msg('必须小于数据总量');
            $scope.pagesizefp = "200";
        }else if(Number($scope.pagesizefp)>Number($scope.pageSizea)){
            $scope.pagesizefp = $scope.pageSizea;
        }
    	if($scope.pagesizefp==""){
    		layer.msg('未填写提取条数!');
            layer.closeAll('loading');
    	}else if($scope.page_size==null){
            layer.msg('正在查询数据总数，请稍后再试!');
            layer.closeAll('loading');
        }else if(Number($scope.page_size)!=0){
            layer.msg('还有未筛选完的数据不能提取!');
            layer.closeAll('loading');
        }else{
    		$http({
                method : 'get',
                // url : "updateStatuefpName.action",
                url : "updateStatuefpNamefz.action",
                params:{
                	HPZL:$scope.data_a,//号牌种类
                    HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                    CJDZ:$('#exampledata1').val(),//违法地点
                    startTime:$("#starttime").val(),//开始时间
                    endTime:$("#endtime").val(),//结束时间
                    WFDM:$scope.data_d,//违法行为
                    CSMZ:$scope.data_f,//厂商名字
                    SFSH:-1,//初筛 0:通过，1:作废。默认-1
                    userName:$scope.person.userName,
                    pageSize:$scope.pagesizefp
                }
            }).success(function(data) {
                layer.msg(data);
                $scope.chaxunztsa();
            }).error(function() {
                $scope.popup1('无法连接到服务器');
            });
    	};
    };
    
    //释放数据
    $scope.shifangdata = function(){
    	//var userna = JSON.parse($scope.userName);
    	$scope.lopopup();
    	$http({
            method : 'get',
            // url : "updateghdata.action",
            url : "updateghdatafz.action",
            params:{
                userName:$scope.person.userName
            }
        }).success(function(data) {
        	layer.msg(data);
            $scope.chaxunztsa();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };


    //详情跳转
	$scope.xqshaixuan = function (x) {
			var itemslist = [];
			angular.forEach($scope.fpdataobj.list,function(data,index){
				itemslist[index] = data.sysid;
			});
            $cookieStore.put("csidlist",itemslist);
            layer.open({
                type : 2,
                title : '违法数据初筛详情',
                shadeClose : true,
                shade : 0.8,
                area: ['100%', '100%'],
                content : "tpl/illegalitiesfpxq.html?id=" + x.sysid + "&illega=1",
                end:function () {
                    $cookieStore.remove("csidlist");
                    $scope.chaxun($scope.fpdataobj.pageNum);
                }
            });
    };
    $scope.wfddcs = function(dat){
        if(dat==1){
            $scope.cswfdda="";
        }
        $http({
            method : 'get',
            // url : GserverURL + "findAddresscs.action",
            url : GserverURL + "findAddresscsfz.action",
            params : {
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                //HPZL:$scope.mjwfList.data_a,//号牌种类
                WFDM:$scope.data_d,//违法代码
                CJDZ:$scope.cswfdda//违法地点
            }
        }).success(function(data) {
            var da = data;
            var number = 1;
            angular.forEach(da, function(data,index) {
                data["xuhao"] = number;
                number++;
            });
            $scope.itemscs = da;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.wfddcs(1);
    $scope.csillegalityPlace = function(x) {
        document.getElementById("guanbics").click();
        $('#exampledata1').selectpicker('val', x.CJDZ);
        $('#exampledata1').selectpicker('refresh');
    };
});
//废片筛选查询
app.controller('ScrapQueryCtrl',function($scope, $http, $rootScope,$cookieStore) {
    $scope.data_cc = "";
    $scope.data_c = "";
    $scope.fpdataobj = {firstPage: 0,list:[],navigatepageNums: [],nextPage: 0,pageNum: 0,pageSize: 0,pages: 0,prePage: 0,size: 0,startRow: 0,total: 0};
    $scope.cqzs = "100";
    $scope.data_e = "0";
    //查询
    $http({
        method : 'get',
        url : GserverURL + "queryAll.action"
    }).success(function(data) {
        $scope.params = data[0];
    }).error(function() {
        $scope.popup1('无法连接到服务器');
    });
    $scope.csuser = function(){
        $http({
            method : 'get',
            url : GserverURL + "queryUser.action"
        }).success(function(data) {
            var renyuan = data;
            $("#exampleuser").selectpicker({
                noneSelectedText : '请选择'//默认显示内容
            });
            $(window).on('load', function() {
                $('#exampleuser').selectpicker('val', '');
                $('#exampleuser').selectpicker('refresh');
            });
            var select = $("#exampleuser");
            select.append("<option value=''>请选择</option>");
            angular.forEach(renyuan, function(data, index) {
                select.append("<option value='"+data.userName+"'>"  + data.userName + "</option>");
                if(index==renyuan.length-1){
                    $('#exampleuser').selectpicker('val', '');
                    $('#exampleuser').selectpicker('refresh');
                }
            });
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.csuser();
    $scope.example = function(){
        $http({
            method : 'get',
            url : GserverURL + "findAddressfz.action",
        }).success(function(data) {
            var renyuan1 = data;
            $("#exampledata1").selectpicker({
                noneSelectedText : '请选择'//默认显示内容
            });
            $(window).on('load', function() {
                $('#exampledata1').selectpicker('val', '');
                $('#exampledata1').selectpicker('refresh');
            });
            var select = $("#exampledata1");
            select.append("<option value=''>请选择</option>");
            angular.forEach(renyuan1, function(data, index) {
                select.append("<option value='"+data.CJDZ+"'>"  + data.CJDZ + "</option>");
                if(index==renyuan1.length-1){
                    $('#exampledata1').selectpicker('val', '');
                    $('#exampledata1').selectpicker('refresh');
                }
            });

        }).error(function() {
        });
    };
    $scope.example();
    $scope.chaxunzts = function(d){
        $scope.lopopup();
        $http({
            method : 'get',
            url : GserverURL + "findPageByfz.action",
            params:{
                userName:$('#exampleuser').val(),//初筛人员
                HPZL:$scope.data_a,//号牌种类
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$('#starttime').val(),//开始时间
                endTime:$('#endtime').val(),//结束时间
                WFDM:$scope.data_d,//数据来源
                CSMZ:$scope.data_f,//厂商名字
                SFSH:$scope.data_e,
                pageNo:d,//第几页
                pageSize:$scope.cqzs
            }
        }).success(function(data) {
            layer.closeAll('loading');
            $cookieStore.remove("csidlist");
            $scope.fpdataobj = data;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };

    //详情跳转
    $scope.xqshaixuan = function (x) {
        var itemslist = [];
        angular.forEach($scope.fpdataobj.list,function(data,index){
            itemslist[index] = data.sysid;
        });
        $cookieStore.put("csidlist",itemslist);
        layer.open({
            type : 2,
            title : '违法数据初筛详情',
            shadeClose : true,
            shade : 0.8,
            area: ['100%', '100%'],
            content : "tpl/illegalitiesfpxq.html?id=" + x.sysid + "&illega=2",
            end:function () {
                $cookieStore.remove("csidlist");
                $scope.chaxunzts($scope.fpdataobj.pageNum);
            }
        });
    };
});
//废片筛选统计
app.controller('ScrapStatisticsCtrl', function($scope, $http, $rootScope,$cookieStore) {
    $scope.person = $cookieStore.get("person");
    if ($scope.person == null || $scope.person == ""){
        $cookieStore.remove("person");
        window.location = "index.html";
    };
    //查询
    $http({
        method : 'get',
        url : GserverURL + "queryAll.action"
    }).success(function(data) {
        $scope.params = data[0];
    }).error(function() {
        $scope.popup1('无法连接到服务器');
    });
    $http({
        method : 'GET',
        url : GserverURL + "queryUser.action",
        // 传递数据作为字符串，从前台传到后台
    }).success(function(data) {
        $scope.user = data;
    }).error(function() {
        $scope.popup("#/User", "服务器连接失败");
    });
    function today(){
        var today=new Date();
        var h=today.getFullYear();
        var m=today.getMonth()+1;
        var d=today.getDate();
        var hh=today.getHours();
        var mm=today.getMinutes();
        var ss=today.getSeconds();
        m= m<10?"0"+m:m;
        d= d<10?"0"+d:d;
        hh = hh < 10 ? "0" + hh:hh;
        mm = mm < 10 ? "0" +  mm:mm;
        ss = ss < 10 ? "0" + ss:ss;
        return h+"-"+m+"-"+d;
    };
    $("#starttime").val(today()+" "+"00:00:00");
    $("#endtime").val(today()+" "+"23:59:59");
    $scope.chaxunzts = function(){
        $scope.lopopup();
        $http({
            method : 'get',
            url : GserverURL + "finduserandcountfz.action",
            //url : GserverURL + "finduserandcountold.action",
            params:{
                startTime:$("#starttime").val(),//时间
                endTime:$("#endtime").val(),//时间
                userName:$scope.data_user,//筛选人
                WFDM:$scope.data_d//违法行为
            }
        }).success(function(data) {
            layer.closeAll('loading');
            var da = data;
            if(da!=""&&da!=null){
                var ssy = {
                    userName:"合计",
                    tovoid:0,
                    pass:0,
                    allTotal:0
                };
                var deletelist = [];
                angular.forEach(da,function(dat,index){
                    if(dat.tovoid!=0||dat.pass!=0||dat.allTotal!=0){
                        deletelist.push(dat);
                    }
                    ssy.tovoid = ssy.tovoid+dat.tovoid;
                    ssy.pass = ssy.pass+dat.pass;
                    ssy.allTotal = ssy.allTotal+dat.allTotal;
                });
                deletelist.push(ssy);
            }
            $scope.saixuandata = deletelist;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts();
});