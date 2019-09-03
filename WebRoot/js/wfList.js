app.filter('data_typea', function() { //可以注入依赖
    return function(text) {
        switch(text){
            case 1:return "未机筛";
            case 2:return "机筛";
        };
    }
});
app.controller('wfListCtrl', function($scope, $http, $rootScope,$cookieStore) {
	$scope.person = $cookieStore.get("person");
    $cookieStore.remove("csidlist");
	if ($scope.person == null || $scope.person == ""){
		$cookieStore.remove("person");
		window.location = "index.html";
	};
	$scope.data_cc = "";
	$scope.data_c = "";
	$scope.data_type = "2";
    $scope.pageSize = 0;
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
    $scope.cqzs = "200";
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
            url : GserverURL + "finduserandcount2old.action",
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
    $scope.pagesizefp = "";
  //判断数字
    $scope.panduanshuzi = function(){
    	if($scope.pageSizea==""){
    		layer.msg('还未查询数据');
    		$scope.pagesizefp = "";
    	}else if($scope.pagesizefp === "" || $scope.pagesizefp ==null){
    		layer.msg('只能填写数字');
	    	$scope.pagesizefp = "";
    	}else if(isNaN($scope.pagesizefp)){
    		layer.msg('只能填写数字');
    		$scope.pagesizefp = "";
    	}
    };
    //数据总数
    $scope.chaxunztsa = function(){
        $scope.lopopup();
        $http({
            method : 'get',
            // url : GserverURL + "getCountfpName.action",
            url : GserverURL + "getCountfpNameold.action",
            params:{
            	userName:"1",
            	HPZL:$scope.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.data_f,//厂商名字
                SFSH:-1,//初筛 0:通过，1:作废。默认-1
                SJZT:$scope.data_type //初筛 1:未通过机器筛选，2:机器筛选后的
            }
        }).success(function(data) {
        	$scope.pageSizea = data;
            $scope.chaxun();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };

    //分配数据
    $scope.fenpeidata = function(){
        $scope.lopopup();
    	//var userna = JSON.parse($scope.userName);
        if(Number($scope.pagesizefp)>200){
            //layer.msg('必须小于数据总量');
            $scope.pagesizefp = 200;
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
                url : "updateStatuefpNameold.action",
                params:{
                	HPZL:$scope.data_a,//号牌种类
                	HPYS:$scope.data_b,//号牌颜色
                    HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                    CJDZ:$('#exampledata1').val(),//违法地点
                    startTime:$("#starttime").val(),//开始时间
                    endTime:$("#endtime").val(),//结束时间
                    WFDM:$scope.data_d,//违法行为
                    FXBH:$scope.data_e,//方向
                    CSMZ:$scope.data_f,//厂商名字
                    SFSH:-1,//初筛 0:通过，1:作废。默认-1
                    userName:$scope.person.userName,
                    pageSize:$scope.pagesizefp,
                    SJZT:$scope.data_type //初筛 1:未通过机器筛选，2:机器筛选后的
                }
            }).success(function(data) {
                layer.msg(data);
                $scope.chaxunztsa();
                $scope.pagesizefp = "";
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
            url : "updateghdataold.action",
            params:{
                userName:$scope.person.userName
            }
        }).success(function(data) {
        	layer.msg(data);
            $scope.chaxunztsa();
            $scope.pagesizefp = "";
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts = function(){
    	$scope.lopopup();
        $http({
            method : 'get',
            // url : GserverURL + "getCount.action",
            url : GserverURL + "getCountold.action",
            params:{
            	userName:$scope.person.userName,
            	HPZL:$scope.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.data_f,//厂商名字
                SFSH:-1,
                SJZT:$scope.data_type //初筛 1:未通过机器筛选，2:机器筛选后的
            }
        }).success(function(data) {
            $scope.pageSize = data;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    //$scope.chaxunzts();
    $scope.chaxun = function(){
        $http({
            method : 'get',
            // url : GserverURL + "findPageBy.action",
            url : GserverURL + "findPageByold.action",
            params:{
            	userName:$scope.person.userName,
            	HPZL:$scope.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.data_f,//厂商名字
                SFSH:-1,
                pageSize:$scope.cqzs,//抽取条数
                pageNow:$scope.dqy,//当前页
                SJZT:$scope.data_type //初筛 1:未通过机器筛选，2:机器筛选后的
            }
        }).success(function(data) {
            layer.closeAll('loading');
            $scope.page_size = data.length;
            $cookieStore.remove("csidlist");
            $scope.items = data;
            $scope.tongjisla();
            //$scope.fengyez(data);
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunztsa();

    //分页
    $scope.setData = function() {
        $http({
            method : 'get',
            // url : GserverURL + "findPageBy.action",
            url : GserverURL + "findPageByold.action",
            params:{
            	userName:$scope.person.userName,
            	HPZL:$scope.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.data_f,//厂商名字
                SFSH:-1,
                pageSize:$scope.cqzs,//抽取条数
                pageNow:$scope.dqy,//当前页
                SJZT:$scope.data_type //初筛 1:未通过机器筛选，2:机器筛选后的
            }
        }).success(function(data) {
            $cookieStore.remove("csidlist");
            $scope.items = data;
            $scope.tongjisla();
            $scope.chaxunztsa();
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
    $scope.remove = function(x1) {
        layer.confirm('确定作废吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $scope.lopopup();
            $http({
                method : 'get',
                url : "updateStatus.action",
                params:{
                	sysid:x1.sysid,
                	HPHM:x1.HPHM,
                	userId : $scope.person.userId,
                	userName : $scope.person.userName,
                	secId : $scope.person.secId,
                	secName : $scope.person.secName,
                	SFSH:1
                }
            }).success(function(data) {
                $scope.popup1(data);
                $scope.setData();
            }).error(function() {
                $scope.popup1('无法连接到服务器');
            });
        });
	};
    $scope.ok = function(x1) {
        layer.confirm('确定通过吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $scope.lopopup();
            $http({
                method : 'get',
                url : "updateStatus.action",
                params:{
                    sysid:x1.sysid,
                    HPHM:x1.HPHM,
                    userId : $scope.person.userId,
                	userName : $scope.person.userName,
                	secId : $scope.person.secId,
                	secName : $scope.person.secName,
                    SFSH:0
                }
            }).success(function(data) {
                $scope.popup1(data);
                $scope.setData();
            }).error(function() {
                $scope.popup1('无法连接到服务器');
            });
        });
    };
    //详情跳转
	$scope.xqshaixuan = function (x) {
			var itemslist = [];
			angular.forEach($scope.items,function(data,index){
				itemslist[index] = data.sysid;
			});
            $cookieStore.put("csidlist",itemslist);
            layer.open({
                type : 2,
                title : '违法数据初筛详情',
                shadeClose : true,
                shade : 0.8,
                area: ['100%', '100%'],
                content : "tpl/illegalitiesxq.html?id=" + x.sysid,
                end:function () {
                    $cookieStore.remove("csidlist");
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
	$scope.delIllegal = function() {
        $scope.lopopup();
		if ($scope.checked.length == 0) {
			$scope.popup1("未选中数据");
		}else if($scope.checked.length > 1){
            $scope.popup1("只能选择1条数据");
        } else {
			layer.confirm("确认要作废这" + $scope.checked.length
					+ "条吗?", {
				title: "提示",
			btn: ['确定', '取消'] //按钮
            }, function() {
                var url = "updateStatus.action";
                $http({
                    method : 'get',
                    url : url,
                    params : {
                        sysid : $scope.checked[0],
                        SFSH : 1
                    }, // 传递数据作为字符串，从前台传到后台
                }).success(function(data) {
                    $scope.popup1('作废成功');
                    $scope.setData();
                }).error(function() {
                    $scope.popup1('无法连接到服务器');
                });
            }, function() {
                layer.closeAll();
            });
		}
	};

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
	$scope.tupiandaochu = function(){
		$http({
            method : 'get',
            url : GserverURL + "downimage.action",
            params:{
            	HPZL:$scope.data_a,//号牌种类
            	HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$("#starttime").val(),//开始时间
                endTime:$("#endtime").val(),//结束时间
                WFDM:$scope.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                CSMZ:$scope.data_f,//厂商名字
                SFSH:-1
            }
        }).success(function(data) {
            $scope.popup1(data);
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
	};
    $scope.wfddcs = function(dat){
        if(dat==1){
            $scope.cswfdda="";
        }
        $http({
            method : 'get',
            // url : GserverURL + "findAddresscs.action",
            url : GserverURL + "findAddresscsold.action",
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
//违法地点详细信息
app.controller('wfdidianCtrl', function($scope, $http, $rootScope) {
	//查询
    $http({
        method : 'get',
        // url : GserverURL + "findAddress.action"
        url : GserverURL + "findAddressold.action"
    }).success(function(data) {
    	var da = data;
    	var number = 1;
    	angular.forEach(da, function(data,index) {
			data["xuhao"] = number;
			number++;
		});
    	$scope.wfdidian = da;
    }).error(function() {
        $scope.popup1('无法连接到服务器');
    });
    
    $scope.illegalityPlace = function(x) {
        document.getElementById("guanbi").click();
        $rootScope.wfplace = x.CJDZ;
    };
});
//路口数据统计
app.controller('RoadStatisticalCtrl', function($scope, $http, $rootScope) {
	//查询
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
	$("#starttime").val(today2(0)+" "+ "00:00:00");
	$("#endtime").val(today2(0)+" "+ "23:59:59");
    $("#batch").val("");
    $scope.getsbmc = function(){
        $http({
            method : 'get',
            url : "http://41.5.253.166:8080/dzjccx/getsbmc"
        }).success(function(data) {
            //console.log(data);
            $scope.sbmc = data;
            // $scope.pageSize = data.kedatjs.length;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts = function(){
        $scope.lopopup();
        $http({
            method : 'get',
            url : "http://41.5.253.166:8080/dzjccx/blurryselect",
            params:{
                starttime:$("#starttime").val(),//开始时间
                endtime:$("#endtime").val(),//结束时间
                sbmc:$("#batch").val()//地址
            }
        }).success(function(data) {
            layer.closeAll('loading');
            $scope.items = data;
            $scope.pageSize = data.kedatjs.length;
            $scope.getsbmc();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts();
	 
	 $scope.cxjgdc  = function(){
			$scope.lopopup();
			$http({
				method : 'get',
				url : GserverURL + "daochulukou.action",
				params : {
					startTime:$("#starttime").val(),//开始时间
	                endTime:$("#endtime").val()//结束时间
					//signDate:myDate.getFullYear()+'-'+Month+'-'+myDate.getDate()
					//qdtype:"签退"
				}, // 传递数据作为字符串，从前台传到后台
			}).success(function(data) {
				window.open("/dzjc/Excel/"+data,"_black");
				layer.closeAll();
			}).error(function() {
				$scope.popup1('无法连接到服务器');
			});
		}

    var idTmr;
    function  getExplorer() {
        var explorer = window.navigator.userAgent ;
        //ie
        if (explorer.indexOf("MSIE") >= 0) {
            return 'ie';
        }
        //firefox
        else if (explorer.indexOf("Firefox") >= 0) {
            return 'Firefox';
        }
        //Chrome
        else if (explorer.indexOf("Chrome") >= 0) {
            return 'Chrome';
        }
        //Opera
        else if (explorer.indexOf("Opera") >= 0) {
            return 'Opera';
        }
        //Safari
        else if (explorer.indexOf("Safari") >= 0) {
            return 'Safari';
        }
    }
    $scope.method5 = function(tableid) {
        if (getExplorer() == 'ie') {
            var curTbl = document.getElementById(tableid);
            var oXL = new ActiveXObject("Excel.Application");
            var oWB = oXL.Workbooks.Add();
            var xlsheet = oWB.Worksheets(1);
            var sel = document.body.createTextRange();
            sel.moveToElementText(curTbl);
            sel.select();
            sel.execCommand("Copy");
            xlsheet.Paste();
            oXL.Visible = true;

            try {
                var fname = oXL.Application.GetSaveAsFilename("Excel.xls",
                    "Excel Spreadsheets (*.xls), *.xls");
            } catch (e) {
                print("Nested catch caught " + e);
            } finally {
                oWB.SaveAs(fname);
                oWB.Close(savechanges = false);
                oXL.Quit();
                oXL = null;
                idTmr = window.setInterval("Cleanup();", 1);
            }

        } else {
            tableToExcel(tableid)
        }
    }
    function Cleanup() {
        window.clearInterval(idTmr);
        CollectGarbage();
    }
    var tableToExcel = (function() {
        var uri = 'data:application/vnd.ms-excel;base64,', template = '<html><head><meta charset="UTF-8"></head><body><table  border="1">{table}</table></body></html>', base64 = function(
            s) {
            return window.btoa(unescape(encodeURIComponent(s)))
        }, format = function(s, c) {
            return s.replace(/{(\w+)}/g, function(m, p) {
                return c[p];
            })
        }
        return function(table, name) {
            if (!table.nodeType)
                table = document.getElementById(table)
            var ctx = {
                worksheet : name || 'Worksheet',
                table : table.innerHTML
            }
            var d2 = new Date();
            document.getElementById("hzStatisticaa").href = uri + base64(format(template, ctx));
            document.getElementById("hzStatisticaa").download = "路口数据统计("+(d2.getMonth()+1)+"-"+d2.getDate()+").xls";
        }
    })();
});
//路口汇总统计
app.controller('hzStatisticalCtrl', function($scope, $http, $rootScope) {
    //查询
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
    $scope.chaxunzts = function(){
        $scope.da_time = $("#starttime").val() + " — " +$("#endtime").val();
        $scope.lopopup();
        $http({
            method : 'get',
            url : "http://41.5.252.7:8868/requhan",
            params:{
                start:$("#starttime").val(),//开始时间
                end:$("#endtime").val()//结束时间
            }
        }).success(function(data) {
            if(data.requst=="2"){
                $scope.items = data.data;
                $scope.pageSize = $scope.items.length-1;
            }else{
                console.log("失败");
            }
            layer.closeAll();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts();

    var idTmr;
    function  getExplorer() {
        var explorer = window.navigator.userAgent ;
        //ie
        if (explorer.indexOf("MSIE") >= 0) {
            return 'ie';
        }
        //firefox
        else if (explorer.indexOf("Firefox") >= 0) {
            return 'Firefox';
        }
        //Chrome
        else if (explorer.indexOf("Chrome") >= 0) {
            return 'Chrome';
        }
        //Opera
        else if (explorer.indexOf("Opera") >= 0) {
            return 'Opera';
        }
        //Safari
        else if (explorer.indexOf("Safari") >= 0) {
            return 'Safari';
        }
    }
    $scope.method5 = function(tableid) {
        if (getExplorer() == 'ie') {
            var curTbl = document.getElementById(tableid);
            var oXL = new ActiveXObject("Excel.Application");
            var oWB = oXL.Workbooks.Add();
            var xlsheet = oWB.Worksheets(1);
            var sel = document.body.createTextRange();
            sel.moveToElementText(curTbl);
            sel.select();
            sel.execCommand("Copy");
            xlsheet.Paste();
            oXL.Visible = true;

            try {
                var fname = oXL.Application.GetSaveAsFilename("Excel.xls",
                    "Excel Spreadsheets (*.xls), *.xls");
            } catch (e) {
                print("Nested catch caught " + e);
            } finally {
                oWB.SaveAs(fname);
                oWB.Close(savechanges = false);
                oXL.Quit();
                oXL = null;
                idTmr = window.setInterval("Cleanup();", 1);
            }

        } else {
            tableToExcel(tableid)
        }
    }
    function Cleanup() {
        window.clearInterval(idTmr);
        CollectGarbage();
    }
    var tableToExcel = (function() {
        var uri = 'data:application/vnd.ms-excel;base64,', template = '<html><head><meta charset="UTF-8"></head><body><table  border="1">{table}</table></body></html>', base64 = function(
            s) {
            return window.btoa(unescape(encodeURIComponent(s)))
        }, format = function(s, c) {
            return s.replace(/{(\w+)}/g, function(m, p) {
                return c[p];
            })
        }
        return function(table, name) {
            if (!table.nodeType)
                table = document.getElementById(table)
            var ctx = {
                worksheet : name || 'Worksheet',
                table : table.innerHTML
            }
            var d2 = new Date();
            document.getElementById("hzStatisticaa").href = uri + base64(format(template, ctx));
            document.getElementById("hzStatisticaa").download = "电子警察路口数据统计("+(d2.getMonth()+1)+"-"+d2.getDate()+").xls";
        }
    })();
});