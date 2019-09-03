app.filter('replacepur', function () {//过滤器
    return function (input) {
   		switch(input)
			{
			case 1:return '未审核'; break;
			case 2:return '已通过'; break;
			case 3:return '作废'; break;
			}
    }
});
app.controller('mjwfListCtrl', function($scope, $http, $rootScope,$cookieStore) {
	$scope.person = $cookieStore.get("person");
    $cookieStore.remove("itemsidlist");
	if ($scope.person == null || $scope.person == ""){
		$cookieStore.remove("person");
		window.location = "index.html";
	};
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
	if($cookieStore.get("mjwfListdata")!=undefined){
		$scope.mjwfList = $cookieStore.get("mjwfListdata");
	}else{
		$scope.mjwfList = {CJDZ: "",data_c: "",data_cc: "",endtime: today2(3)+" "+ "23:59:59",pagesizefp: "50",starttime: today2(3)+" "+ "00:00:00"};
	};
	$("#starttime").val($scope.mjwfList.starttime);
    $("#endtime").val($scope.mjwfList.endtime);
	$scope.data_g = "1";
	if($scope.person.permissions.qbsj==true){
		$scope.userqbsj = "";
	}else{
		$scope.userqbsj = $scope.person.userName;
	};
    $scope.items = [];
    $scope.pageList = [];
    $scope.liebiao = "图片";
    $scope.tupian = false;
    $scope.xiangqing = true;
    $scope.page_size = null;//判断是否提取数据
    $scope.xiayibu = function () {
    	if($scope.tupian == true){
            $scope.liebiao = "图片";
            $scope.tupian = false;
            $scope.xiangqing = true;
		}else{
            $scope.liebiao = "列表";
            $scope.tupian = true;
            $scope.xiangqing = false;
		}
    };
    $scope.dqy = 1;
    $scope.cqzs = "100";
    //统计数量
	$scope.tongjisladata = {};
    $scope.tongjisla = function(){
    	$http({
            method : 'get',
            //url : "finduserandcountmj.action",
            url : GserverURL + "finduserandcountmjnew.action",
            params:{
            	startTime:today()+" "+ "00:00:00",//时间
            	endTime:today()+" "+ "23:59:59",//时间
            	mjuserName:$scope.person.userName//筛选人
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
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    
    //判断数字
    $scope.panduanshuzi = function(){
    	if($scope.pageSizea==""){
    		layer.msg('还未查询数据');
    		//$scope.mjwfList.pagesizefp = "";
    	}else if($scope.mjwfList.pagesizefp === "" || $scope.mjwfList.pagesizefp ==null){
    		layer.msg('只能填写数字');
	    	//$scope.mjwfList.pagesizefp = "";
    	}else if(isNaN($scope.mjwfList.pagesizefp)){
    		layer.msg('只能填写数字');
    		//$scope.mjwfList.pagesizefp = "";
    	}
    	$cookieStore.put("mjwfListdata",$scope.mjwfList);
    };
    //数据总数
    $scope.chaxunztsa = function(){
        $http({
            method : 'get',
            //url : "getCountfpNamemj.action",
            url : GserverURL + "getCountfpNamemjnew.action",
            params:{
            	mjuserName:"1",
            	HPZL:$scope.mjwfList.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.mjwfList.data_cc+$scope.mjwfList.data_c,//号牌号码
                CJDZ:$scope.mjwfList.CJDZ,//违法地点
                startTime:$scope.mjwfList.starttime,//开始时间
                endTime:$scope.mjwfList.endtime,//结束时间
                WFDM:$scope.mjwfList.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.mjwfList.data_f,//厂商名字
                SFSH:0,//初筛 0:通过，1:作废。默认-1
            	MJSCZT:1//民警上传状态：2:通过，3:作废。默认1
            }
        }).success(function(data) {
        	$scope.pageSizea = data;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunztsa();
    //分配数据
    $scope.fenpeidata2 = function(datanum){

    	$http({
            method : 'get',
            //url : "updateStatuefpNamemj.action",
            url : "updateStatuefpNamemjnew.action",
            params:{
            	HPZL:$scope.mjwfList.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.mjwfList.data_cc+$scope.mjwfList.data_c,//号牌号码
                CJDZ:$scope.mjwfList.CJDZ,//违法地点
                startTime:$scope.mjwfList.starttime,//开始时间
                endTime:$scope.mjwfList.endtime,//结束时间
                WFDM:$scope.mjwfList.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.mjwfList.data_f,//厂商名字
                SFSH:0,//初筛 0:通过，1:作废。默认-1
                MJSCZT:1,//民警上传状态：2:通过，3:作废。默认1
                mjuserName:$scope.person.userName,
                pageSize:datanum
            }
        }).success(function(data) {
            $scope.popup1(data);
            $scope.chaxunzts();
            //$scope.mjwfList.pagesizefp = "";
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.fenpeidata = function(){
    	//var userna = JSON.parse($scope.userName); 
    	$scope.lopopup();
        if(Number($scope.mjwfList.pagesizefp)>50){
            //layer.msg('必须小于数据总量');
            $scope.mjwfList.pagesizefp = 50;
        }else if(Number($scope.mjwfList.pagesizefp)>Number($scope.pageSizea)){
            $scope.mjwfList.pagesizefp = $scope.pageSizea;
        }
        if($scope.mjwfList.pagesizefp==""){
            layer.msg('未填写提取条数!');
            layer.closeAll('loading');
        }else if($scope.page_size==null){
            layer.msg('正在查询数据总数，请稍后再试!');
            layer.closeAll('loading');
        }else if(Number($scope.page_size)!=0){
            layer.msg('还有未筛选完的数据不能提取!');
            layer.closeAll('loading');
        }else if(isNaN($scope.mjwfList.pagesizefp)){
            layer.closeAll('loading');
            layer.msg('只能填写数字');
            //$scope.mjwfList.pagesizefp = "";
        }else if($scope.pageSizea == 0 || $scope.pageSizea == "0"){
            layer.closeAll('loading');
            layer.msg('没有数据');
        }else if($scope.mjwfList.pagesizefp === "" || $scope.mjwfList.pagesizefp ==null){
    		$scope.fenpeidata2($scope.pageSizea);
    	}else{
    		$scope.fenpeidata2($scope.mjwfList.pagesizefp);
    	};
    };
    
    //释放数据
    $scope.shifangdata = function(){
    	//var userna = JSON.parse($scope.userName); 
    	$scope.lopopup();
    	$http({
            method : 'get',
            //url : "updateghdatamj.action",
            url : "updateghdatamjnew.action",
            params:{
                mjuserName:$scope.person.userName
            }
        }).success(function(data) {
        	layer.msg(data);
            $scope.chaxunzts();
            //$scope.mjwfList.pagesizefp = "";
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
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
    $("#exampledata1").selectpicker({  
        noneSelectedText : '请选择'//默认显示内容  
    });
    $scope.example = function(){
    	$scope.lopopup();
		$http({
			method : 'get',
			//url : "findAddressmj.action",
            url : GserverURL + "findAddressmjnew.action",
		}).success(function(data) {
			var renyuan1 = data;
			var select = $("#exampledata1");
			select.append("<option value=''>请选择</option>");
			angular.forEach(renyuan1, function(data, index) {
				 select.append("<option value='"+data.CJDZ+"'>"  + data.CJDZ + "</option>");
				if(index==renyuan1.length-1){
					$('#exampledata1').selectpicker('val', $scope.mjwfList.CJDZ);
				    $('#exampledata1').selectpicker('refresh');
				}
			}); 
			layer.closeAll('loading');
				//$scope.mjwfList = $cookieStore.get("mjwfListdata");
		}).error(function() {
		});
	};
	$scope.example();
    $scope.chaxunzts = function(){
    	$scope.lopopup();
        $http({
            method : 'get',
            //url : "getCount.action",
            url : GserverURL + "getCountnew.action",
            params:{
            	HPZL:$scope.mjwfList.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.mjwfList.data_cc+$scope.mjwfList.data_c,//号牌号码
                CJDZ:$scope.mjwfList.CJDZ,//违法地点
                startTime:$scope.mjwfList.starttime,//开始时间
                endTime:$scope.mjwfList.endtime,//结束时间
                WFDM:$scope.mjwfList.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.mjwfList.data_f,//厂商名字
                mjuserName:$scope.person.userName,
                SFSH:0,//初筛 0:通过，1:作废。默认-1
            	MJSCZT:1//民警上传状态：2:通过，3:作废。默认1
            }
        }).success(function(data) {
            $scope.pageSize = data;
            $scope.chaxun();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts2 = function(){
    	$cookieStore.put("mjwfListdata",$scope.mjwfList);
    };
    $scope.chaxunzts3 = function(){
    	if($scope.mjwfList.CJDZ !== $('#exampledata1').val()||$scope.mjwfList.starttime !== $("#starttime").val()||$scope.mjwfList.endtime !== $("#endtime").val()){
    		$scope.chaxunzts();
    	}
    	$scope.mjwfList.CJDZ = $('#exampledata1').val();
        $scope.mjwfList.starttime = $("#starttime").val();
        $scope.mjwfList.endtime = $("#endtime").val();
        $cookieStore.put("mjwfListdata",$scope.mjwfList);
    };
    //监听数据变化
    $scope.$watch('mjwfList',function(n,o){
    	if(n.pagesizefp == o.pagesizefp){
    		$scope.chaxunzts();
    	}
	},true);
    $scope.chaxun = function(){
        $http({
            method : 'get',
            //url : "findPageBy.action",
            url : GserverURL + "findPageBynew.action",
            params:{
            	HPZL:$scope.mjwfList.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.mjwfList.data_cc+$scope.mjwfList.data_c,//号牌号码
                CJDZ:$scope.mjwfList.CJDZ,//违法地点
                startTime:$scope.mjwfList.starttime,//开始时间
                endTime:$scope.mjwfList.endtime,//结束时间
                WFDM:$scope.mjwfList.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.mjwfList.data_f,//厂商名字
                mjuserName:$scope.person.userName,
                SFSH:0,//初筛 0:通过，1:作废。默认-1
            	MJSCZT:1,//民警上传状态：2:通过，3:作废。默认1
                pageSize:$scope.cqzs,//抽取条数
                pageNow:$scope.dqy//当前页
            }
        }).success(function(data) {
        	layer.closeAll('loading');
            $scope.page_size = data.length;
            $cookieStore.remove("itemsidlist");
            $scope.fengyez(data);
            $scope.tongjisla();
            $scope.chaxunztsa();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    //分页
    $scope.setData = function() {
        $scope.lopopup();
        $http({
            method : 'get',
            //url : "findPageBy.action",
            url : GserverURL + "findPageBynew.action",
            params:{
            	HPZL:$scope.mjwfList.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.mjwfList.data_cc+$scope.mjwfList.data_c,//号牌号码
                CJDZ:$scope.mjwfList.CJDZ,//违法地点
                startTime:$scope.mjwfList.starttime,//开始时间
                endTime:$scope.mjwfList.endtime,//结束时间
                WFDM:$scope.mjwfList.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.mjwfList.data_f,//厂商名字
                mjuserName:$scope.person.userName,
                SFSH:0,//初筛 0:通过，1:作废。默认-1
            	MJSCZT:1,//民警上传状态：2:通过，3:作废。默认1
                pageSize:$scope.cqzs,//抽取条数
                pageNow:$scope.dqy//当前页
            }
        }).success(function(data) {
            layer.closeAll('loading');
            $cookieStore.remove("itemsidlist");
            $scope.items = data;
            $scope.tongjisla();
            $scope.chaxunztsa();
            //$scope.tongjisl();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.fengyez = function(data) {
    	$scope.liebiao = "图片";
        $scope.tupian = false;
        $scope.xiangqing = true;
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
    // $scope.remove = function(x1) {
    //     layer.confirm('确定作废吗？', {
    //         btn: ['确定','取消'] //按钮
    //     }, function(){
    //         $scope.lopopup();
    //         $http({
    //             method : 'get',
    //             url : "updateStatusmj.action",
    //             params:{
    //             	sysid:x1.sysId,
    //             	HPHM:x1.HPHM,
    //             	userId : $scope.person.userId,
    //             	userName : $scope.person.userName,
    //             	secId : $scope.person.secId,
    //             	secName : $scope.person.secName,
    //             	MJSCZT:3//民警上传状态：2:通过，3:作废。默认1
    //             }
    //         }).success(function(data) {
    //             $scope.popup1(data);
    //             $scope.setData();
    //         }).error(function() {
    //             $scope.popup1('无法连接到服务器');
    //         });
    //     });
    // };
    // $scope.ok = function(x1) {
    //     layer.confirm('确定通过吗？', {
    //         btn: ['确定','取消'] //按钮
    //     }, function(){
    //         $scope.lopopup();
    //         $http({
    //             method : 'get',
    //             url : "updateStatusmj.action",
    //             params:{
    //                 sysid:x1.sysId,
    //                 HPHM:x1.HPHM,
    //                 userId : $scope.person.userId,
    //             	userName : $scope.person.userName,
    //             	secId : $scope.person.secId,
    //             	secName : $scope.person.secName,
    //             	MJSCZT:2//民警上传状态：2:通过，3:作废。默认1
    //             }
    //         }).success(function(data) {
    //             $scope.popup1(data);
    //             $scope.setData();
    //         }).error(function() {
    //             $scope.popup1('无法连接到服务器');
    //         });
    //     });
    // };
    //详情跳转
	$scope.xqshaixuan = function (x) {
			var itemslist = [];
			angular.forEach($scope.items,function(data,index){
				itemslist[index] = data.sysid;
			});
            $cookieStore.put("itemsidlist",itemslist);
            //itemslist = [];
            layer.open({
                type : 2,
                title : '违法数据初筛详情',
                shadeClose : true,
                shade : 0.8,
                area: ['100%', '100%'],
                content : "tpl/mjillegalitiesxq.html?id=" + x.sysid,
                end:function () {
                    $cookieStore.remove("itemsidlist");
                    $scope.setData();
                }
            });
    };

	// 全选
	$scope.checked = [];
	$scope.selectAll = function() {
		if ($scope.select_all) {
			$scope.checked = [];
			angular.forEach($scope.items, function(x) {
				x.checked = true;
				$scope.checked.push(x.sysid);
			});
		} else {
			angular.forEach($scope.items, function(x) {
				x.checked = false;
				$scope.checked = [];
			});
		}
		// console.log($scope.checked);
	};
	// 单击选择
	$scope.selectOne = function() {
		angular.forEach($scope.items, function(x) {
			var index = $scope.checked.indexOf(x.sysid);
			if (x.checked && index === -1) {
				$scope.checked.push(x.sysid);
			} else if (!x.checked && index !== -1) {
				$scope.checked.splice(index, 1);
			}
		});
		if ($scope.items.length === $scope.checked.length) {
			$scope.select_all = true;
		} else {
			$scope.select_all = false;
		}

	};

	// 删除
	// $scope.delIllegal = function() {
     //    $scope.lopopup();
	// 	if ($scope.checked.length == 0) {
	// 		$scope.popup1("未选中数据");
	// 	}else if($scope.checked.length > 1){
     //        $scope.popup1("只能选择1条数据");
     //    } else {
	// 		layer.confirm("确认要作废这" + $scope.checked.length
	// 				+ "条吗?", {
	// 			title: "提示",
	// 		btn: ['确定', '取消'] //按钮
     //        }, function() {
     //            var url = "updateStatusmj.action";
     //            $http({
     //                method : 'get',
     //                url : url,
     //                params : {
     //                    sysid : $scope.checked[0],
     //                	MJSCZT:3//民警上传状态：2:通过，3:作废。默认1
     //                }, // 传递数据作为字符串，从前台传到后台
     //            }).success(function(data) {
     //                $scope.popup1('作废成功');
     //                $scope.setData();
     //            }).error(function() {
     //                $scope.popup1('无法连接到服务器');
     //            });
     //        }, function() {
     //            layer.closeAll('loading');
     //        });
	// 	}
	// };

	/*$scope.selecteone1 = function() {
		if ($scope.checked.length == 0) {
			alert("未选中数据");
		} else if ($scope.checked.length > 1) {
			alert("只能选择一条数据");
		} else {
			var url = "http://localhost:8080/jjzdoa/selectTaskByNum.action";
			$http({
				method : 'get',
				url : url,
				params : {
					taskNum : $scope.checked
				}, // 传递数据作为字符串，从前台传到后台
			}).success(function(data) {
				$rootScope.taskNumu = data.taskNum;
				$rootScope.taskSummaryu = data.taskSummary;
				$rootScope.taskFromu = data.taskFrom;
				$rootScope.fbPhoneu = data.fbPhone;
				$rootScope.taskLevelu = data.taskLevel;
				$rootScope.zxManu = data.zxMan;
				$rootScope.taskRemarksu = data.taskRemarks;
				window.location = "#/updateTask";
			}).error(function() {
				alert("服务器连接失败");
			});
		}
		;
	}*/
	
	//违法地点待筛选数据
	//分页
	$scope.fenyewf = function(datax) {
		$scope.datawf = datax;
		//分页总数
		$scope.pageSizewf = 10;
		$scope.zongshuwf = $scope.datawf.length;
		$scope.pageswf = Math.ceil($scope.datawf.length / $scope.pageSizewf); //分页数
		$scope.newPageswf = $scope.pageswf > 5 ? 5 : $scope.pageswf;
		$scope.pageListwf = [];
		$scope.selPagewf = 1;
		//设置表格数据源(分页)
		$scope.setDatawf = function() {
			$scope.itemswf = $scope.datawf.slice(($scope.pageSizewf * ($scope.selPagewf - 1)), ($scope.selPagewf * $scope.pageSizewf)); //通过当前页数筛选出表格当前显示数据
		}
		$scope.itemswf = $scope.datawf.slice(0, $scope.pageSizewf);
		//分页要repeat的数组
		for(var i = 0; i < $scope.newPageswf; i++) {
			$scope.pageListwf.push(i + 1);
		}
		//打印当前选中页索引
		$scope.selectPagewf = function(page) {
			//不能小于1大于最大
			if(page < 1 || page > $scope.pageswf) return;
			//最多显示分页数5
			if(page > 2) {
				//因为只显示5个页数，大于2页开始分页转换
				var newpageList = [];
				for(var i = (page - 3); i < ((page + 2) > $scope.pageswf ? $scope.pageswf : (page + 2)); i++) {
					newpageList.push(i + 1);
				}
				$scope.pageListwf = newpageList;
			}
			$scope.selPagewf = page;
			$scope.setDatawf();
			$scope.isActivePagewf(page);
			//			console.log("选择的页：" + page);
		};
		//设置当前选中页样式
		$scope.isActivePagewf = function(page) {
			return $scope.selPagewf == page;
		};
		//上一页
		$scope.Previouswf = function() {
				$scope.selectPagewf($scope.selPagewf - 1);
			};
			//下一页
		$scope.Nextwf = function() {
			$scope.selectPagewf($scope.selPagewf + 1);
		};
	};
	$scope.wfddcx = function(dat){
		if(dat==1){
			$scope.wfdda="";
		}
		$http({
	        method : 'get',
	        //url : "findAddressmj.action",
            url : GserverURL + "findAddressmjnew.action",
	        params : {
                startTime:$scope.mjwfList.starttime,//开始时间
                endTime:$scope.mjwfList.endtime,//结束时间
	            HPZL:$scope.mjwfList.data_a,//违法代码
	            WFDM:$scope.mjwfList.data_d,//违法代码
	            CJDZ:$scope.wfdda//违法地点
			}
	    }).success(function(data) {
	    	var da = data;
	    	var number = 1;
	    	angular.forEach(da, function(data,index) {
				data["xuhao"] = number;
				number++;
			});
	    	$scope.itemswf = da;
	    }).error(function() {
	        $scope.popup1('无法连接到服务器');
	    });
	};
	$scope.wfddcx(1);
    $scope.illegalityPlace = function(x) {
        document.getElementById("guanbi").click();
        $('#exampledata1').selectpicker('val', x.CJDZ);
        $('#exampledata1').selectpicker('refresh');
        $scope.chaxunzts3();
    };
});
//筛选统计
app.controller('mjwfStatisticsCtrl', function($scope, $http, $rootScope,$cookieStore) {
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
	    mm = mm < 10 ? "0" + mm:mm;
	    ss = ss < 10 ? "0" + ss:ss;
	    return h+"-"+m+"-"+d;
	};
	$("#starttime").val(today()+" "+ "00:00:00");
	$("#endtime").val(today()+" "+ "23:59:59");
	$scope.chaxunzts = function(){
        $scope.lopopup();
        $http({
            method : 'get',
            //url : "finduserandcountmj4.action",
            url : GserverURL + "finduserandcountmj4new.action",
            //url : "http://41.5.252.7:8868/finduser",
            params:{
            	startTime:$("#starttime").val(),//时间
            	endTime:$("#endtime").val(),//时间
            	WFDM:$scope.data_d//违法行为
            }
        }).success(function(data) {
            layer.closeAll('loading');
        	var da = data;
        	if(da!=""&&da!=null){
        		var ssy = {
        			mjuserName:"合计",
    				screening:0,
    				tovoid:0,
    				pass:0,
    				allTotal:0
        		};
        		angular.forEach(da,function(dat,index){
        			ssy.screening = ssy.screening+dat.screening;
        			ssy.tovoid = ssy.tovoid+dat.tovoid;
        			ssy.pass = ssy.pass+dat.pass;
        			ssy.allTotal = ssy.allTotal+dat.allTotal;
        		});
                da.push(ssy);
        	}
            $scope.saixuandata = da;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts();
});