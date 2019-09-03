app.controller('mspecialCtrl',function($scope, $http, $rootScope,$cookieStore) {
	$scope.data_cc = "";
	$scope.data_c = "";
    $scope.items = [];
    $scope.pageList = [];
    $scope.dqy = 1;
    $scope.cqzs = "100";
    $scope.data_e = "0";
    //查询
    $scope.exuser = function(){
    	$http({
            method : 'get',
            //url : GserverURL + "finduserandcountmj4.action"
            url : GserverURL + "finduserandcountmj4new.action"
        }).success(function(data) {
        	var renyuan = data;
			$("#exampledata2").selectpicker({  
	            noneSelectedText : '请选择'//默认显示内容  
	        });
			$(window).on('load', function() {  
	            $('#exampledata2').selectpicker('val', '');  
	            $('#exampledata2').selectpicker('refresh');  
	        });
			var select = $("#exampledata2");
			select.append("<option value=''>请选择</option>");
			angular.forEach(renyuan, function(data, index) {
				 select.append("<option value='"+data.mjuserName+"'>"  + data.mjuserName + "</option>");
				if(index==renyuan.length-1){
					$('#exampledata2').selectpicker('val', '');  
			        $('#exampledata2').selectpicker('refresh');
				}
			}); 
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
	};
    $scope.example = function(){
		$http({
			method : 'get',
            //url : GserverURL + "findAddress.action",
			url : GserverURL + "findAddressold.action",
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
			$scope.exuser();
		}).error(function() {
			layer.closeAll();
		});
	}
	$http({
        method : 'get',
        url : GserverURL + "queryAll.action"
    }).success(function(data) {
    	$scope.example();
        $scope.params = data[0];
    }).error(function() {
        $scope.popup1('无法连接到服务器');
    });
    $scope.chaxunzts = function(){
    	$scope.lopopup();
        $http({
            method : 'get',
            //url : "/dzjc/getCount.action",
            url : GserverURL + "getCountnew.action",
            params:{
            	HPZL:$scope.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//数据来源
                CSMZ:$scope.data_f,//厂商名字
                //FXBH:$scope.data_e,//方向
                mjuserName:$('#exampledata2').val(),
                SFSH:0,
                MJSCZT:$scope.data_e//民警上传状态：2:通过，3:作废。默认1
            }
        }).success(function(data) {
            $scope.pageSize = data;
            $scope.chaxun();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxun = function(){
    	var paramsaa = {
            	HPZL:$scope.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//数据来源
                CSMZ:$scope.data_f,//厂商名字
                //FXBH:$scope.data_e,//方向
                mjuserName:$('#exampledata2').val(),
                SFSH:0,
                MJSCZT:$scope.data_e,//民警上传状态：2:通过，3:作废。默认1
                pageSize:$scope.cqzs,//抽取条数
                pageNow:$scope.dqy//当前页
        };
        $http({
            method : 'get',
            //url : "/dzjc/findPageBy.action",
            url : GserverURL + "findPageBynew.action",
            params:paramsaa
        }).success(function(data) {
        	layer.closeAll();
            var da = data;
            angular.forEach(da, function(data, index) {
            	switch(data.MJSCZT){
	                case 1:data.MJSCZT='未审核'; break;
	                case 2:data.MJSCZT='已通过'; break;
	                case 3:data.MJSCZT='已作废'; break;
	            };
            });
            $scope.fengyez(da);
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    //分页
    $scope.setData = function() {
        $http({
            method : 'get',
            //url : "/dzjc/findPageBy.action",
            url : GserverURL + "findPageBynew.action",
            params:{
            	
            	HPZL:$scope.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//数据来源
                CSMZ:$scope.data_f,//厂商名字
                //FXBH:$scope.data_e,//方向
                mjuserName:$('#exampledata2').val(),
                SFSH:0,
                MJSCZT:$scope.data_e,//民警上传状态：2:通过，3:作废。默认1
                pageSize:$scope.cqzs,//抽取条数
                pageNow:$scope.dqy//当前页
            }
        }).success(function(data) {
            var da = data;
            angular.forEach(da, function(data, index) {
                switch(data.MJSCZT){
                    case 1:data.MJSCZT='未审核'; break;
                    case 2:data.MJSCZT='已通过'; break;
                    case 3:data.MJSCZT='已作废'; break;
                };
            });
            $cookieStore.remove("fhcxidlist");
            $scope.items = da;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.fengyez = function(data) {
        $scope.liebiao = "列表";
        $scope.tupian = true;
        $scope.xiangqing = false;
        $scope.pages = Math.ceil(  Number($scope.pageSize)/Number($scope.cqzs));//分页数
        //分页总数
        $scope.zongshu = $scope.pageSize;
        $scope.newPages = $scope.pages > 5 ? 5 : $scope.pages;
        $scope.pageList = [];
        $scope.selPage = 1;
        //设置表格数据源(分页)
        $scope.items = data;
        //分页要repeat的数组
        for(var i = 0; i < $scope.newPages; i++) {
            $scope.pageList.push(i + 1);
        }
        //打印当前选中页索引
        $scope.selectPage = function(page) {
            //不能小于1大于最大
            if(page < 1 || page > $scope.pages) return;
            //最多显示分页数5
            if(page > 2) {
                //因为只显示5个页数，大于2页开始分页转换
                var newpageList = [];
                for(var i = (page - 3); i < ((page + 2) > $scope.pages ? $scope.pages : (page + 2)); i++) {
                    newpageList.push(i + 1);
                }
                $scope.pageList = newpageList;
            }
            $scope.selPage = page;
            $scope.dqy = page;
            $scope.setData();
            $scope.isActivePage(page);
            //			console.log("选择的页：" + page);
        };
        //设置当前选中页样式
        $scope.isActivePage = function(page) {
            return $scope.selPage == page;
        };
        //上一页
        $scope.Previous = function() {
            $scope.selectPage($scope.selPage - 1);
        };
        //下一页
        $scope.Next = function() {
            $scope.selectPage($scope.selPage + 1);
        };
    };
  //详情跳转
	$scope.xqshaixuan = function (x) {
            var itemslist = [];
            angular.forEach($scope.items,function(data,index){
                itemslist[index] = data.sysid;
            });
            $cookieStore.put("fhcxidlist",itemslist);
            layer.open({
                type : 2,
                title : '违法数据初筛详情',
                shadeClose : true,
                shade : 0.8,
                area: ['100%', '100%'],
                content : "tpl/mjillegalitiesxx.html?id=" + x.sysid,
                end:function () {
                    $cookieStore.remove("fhcxidlist");
                    $scope.setData();
                }
            });
    };
});
