//数据管理
app.controller('dataManagementCtrl', function($scope, $http, $rootScope) {
    $scope.item = [{
        'ps_Num' :1,
        'ps_Id' : 1,
        'ps_description' : '号牌种类',
		'data_a' : 'licensePlateType',
        'data_b' : 'pExplain',
		'urlz':'addPlateType',
        'urlg':'updatePlateType',
        'urls':'deletePlateType',
        'urlc':'queryPlateType'
    },{
        'ps_Num' :2,
        'ps_Id' : 2,
        'ps_description' : '厂商',
        'data_a' : 'manufacturerId',
        'data_b' : 'mExplain',
        'urlz':'addManufacturerNumber',
        'urlg':'updateManufacturerNumber',
        'urls':'deleteManufacturerNumber',
        'urlc':'queryManufacturerNumber'
    },{
        'ps_Num' :3,
        'ps_Id' : 3,
        'ps_description' : '违法数据来源',
        'data_a' : 'illegal_D_D',
        'data_b' : 'iExplain',
        'urlz':'addIllegaDatasource',
        'urlg':'updateIllegaDatasource',
        'urls':'deleteIllegaDatasource',
        'urlc':'queryIllegaDatasource'
    },{
        'ps_Num' :4,
        'ps_Id' : 4,
        'ps_description' : '数据来源',
        'data_a' : 'dataSources',
        'data_b' : 'dExplain',
        'urlz':'addDataSource',
        'urlg':'updateDataSource',
        'urls':'deleteDataSource',
        'urlc':'queryDataSource'
    },{
        'ps_Num' :5,
        'ps_Id' : 5,
        'ps_description' : '证据类型',
        'data_a' : 'eCode',
        'data_b' : 'eExplain',
        'urlz':'addEvidenceType',
        'urlg':'updateEvidenceType',
        'urls':'deleteEvidenceType',
        'urlc':'queryEvidenceType'
    },{
        'ps_Num' :6,
        'ps_Id' : 6,
        'ps_description' : '方向编码',
        'data_a' : 'directionNum',
        'data_b' : 'dExplain',
        'urlz':'addDirectionCode',
        'urlg':'updateDirectionCode',
        'urls':'deleteDirectionCode',
        'urlc':'queryDirectionCode'
    },{
        'ps_Num' :7,
        'ps_Id' : 7,
        'ps_description' : '号牌颜色',
        'data_a' : 'licensePlateColor',
        'data_b' : 'pExplain',
        'urlz':'addPlateColor',
        'urlg':'updatePlateColor',
        'urls':'deletePlateColor',
        'urlc':'queryPlateColor'
    },{
        'ps_Num' :8,
        'ps_Id' : 8,
        'ps_description' : '车身颜色',
        'data_a' : 'cCode',
        'data_b' : 'cExplain',
        'urlz':'addCarBodyC',
        'urlg':'updateCarBodyC',
        'urls':'deleteCarBodyC',
        'urlc':'queryCarBodyC'
    },{
        'ps_Num' :9,
        'ps_Id' : 9,
        'ps_description' : '车标',
        'data_a' : 'cCode',
        'data_b' : 'cExplain',
        'urlz':'addCarLogo',
        'urlg':'updateCarLogo',
        'urls':'deleteCarLogo',
        'urlc':'queryCarLogo'
    },{
        'ps_Num' :10,
        'ps_Id' : 10,
        'ps_description' : '违法行为',
        'data_a' : 'illegal_number',
        'data_b' : 'illegal_explanation',
        'urlz':'addIllegalBehavior',
        'urlg':'updateIllegalBehavior',
        'urls':'deleteIllegalBehavior',
        'urlc':'queryIllegalBehavior'
    },{
        'ps_Num' :11,
        'ps_Id' : 11,
        'ps_description' : '区域',
        'data_a' : 'hxsbbh',
        'data_b' : 'area',
        'urlz':'addSbBh',
        'urlg':'updateSbBh',
        'urls':'deleteSbBh',
        'urlc':'querySbBh'
    }];
    $scope.states.activeItem = $scope.item[0].ps_Num;
    $scope.acheck = $scope.item[0];
    //查询
	$scope.shuaxin = function(datab){
		$scope.acheck = datab;
        var url = datab.urlc + ".action";
        $http({
            method : 'get',
            url : url
        }).success(function(data) {
            var da = [];
            angular.forEach(data, function(data,index) {
                da[index] = {
                    "sysId" : data.sysId,
                    "codeid" : data[datab.data_a],
                    "value" : data[datab.data_b]
                };
            });
            $scope.fenyeq(da);
            $scope.checked = [];
            $scope.select_all = false;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
	};
    $scope.shuaxin($scope.acheck);
	// 全选
	$scope.checked = [];
	$scope.selectAll = function() {
		if ($scope.select_all) {
			$scope.checked = [];
			angular.forEach($scope.items, function(x) {
				x.checked = true;
				$scope.checked.push(x);
			})
		} else {
			angular.forEach($scope.items, function(x) {
				x.checked = false;
				$scope.checked = [];
			})
		}
		// console.log($scope.checked);
	};
	// 双击选择
	$scope.selecttwo = function(x) {

		if (x.checked) {
			x.checked = false;
		} else if (!x.checked) {
			x.checked = true;
		};
		var index = $scope.checked.indexOf(x);
		if (x.checked && index === -1) {
			$scope.checked.push(x);
		} else if (!x.checked && index !== -1) {
			$scope.checked.splice(index, 1);
		};
		if ($scope.items.length === $scope.checked.length) {
			$scope.select_all = true;
		} else {
			$scope.select_all = false;
		};

	};
	// 单击选择
	$scope.selectOne = function() {
		angular.forEach($scope.items, function(x) {
			var index = $scope.checked.indexOf(x);
			if (x.checked && index === -1) {
				$scope.checked.push(x);
			} else if (!x.checked && index !== -1) {
				$scope.checked.splice(index, 1);
			};
		});
		if ($scope.items.length === $scope.checked.length) {
			$scope.select_all = true;
		} else {
			$scope.select_all = false;
		};

	};
	//添加
	$scope.addcanshu = function(){
        layer.open({
            type: 1 //Page层类型
            ,btn:["保存","取消"]
            ,title: '添加'
            ,skin: 'layui-layer-prompt'
            ,content: "<div>" +"编号："+
			"<input type='text' class='layui-layer-input' id='aid'>" +
            "名称："+
			"<input type='text' class='layui-layer-input' id='bvalue'>" +
			"</div>"
            ,yes: function(index, layero){
                $scope.lopopup();
            	var data = {};
            	var url = $scope.acheck.urlz + ".action";
            	data[$scope.acheck.data_a] = $("#aid").val();
                data[$scope.acheck.data_b] = $("#bvalue").val();
                $http({
                    method : 'get',
                    url : url,
                    params:data
                }).success(function(data) {
                    $scope.popup1(data);
                    $scope.shuaxin($scope.acheck);
                }).error(function() {
                    $scope.popup1('无法连接到服务器');
                });
            }
        });
	};
    //修改
    $scope.updcanshu = function(){
    	if($scope.checked.length>1){
            layer.msg('只能选择1条数据！');
		}else if($scope.checked.length==0){
            layer.msg('未选择数据！');
		}else{
            layer.open({
                type: 1 //Page层类型
                //,area: ['500px', '300px']
                ,btn:["保存","取消"]
                ,title: '修改'
                ,skin: 'layui-layer-prompt'
                ,content: "<div>" +"编号："+
                "<input type='text' class='layui-layer-input' value='"+ $scope.checked[0].codeid +"' id='aid'>" +
                "名称："+
                "<input type='text' class='layui-layer-input' value='"+ $scope.checked[0].value +"' id='bvalue'>" +
                "</div>"
                ,yes: function(index, layero){
                    $scope.lopopup();
                    var data = {};
                    var url = $scope.acheck.urlg + ".action";
                    data["sysId"] = $scope.checked[0].sysId;
                    data[$scope.acheck.data_a] = $("#aid").val();
                    data[$scope.acheck.data_b] = $("#bvalue").val();
                    console.log(data);
                    $http({
                        method : 'get',
                        url : url,
                        params : data, // 传递数据作为字符串，从前台传到后台
                    }).success(function(data) {
                        $scope.popup1(data);
                        $scope.shuaxin($scope.acheck);
                    }).error(function() {
                        $scope.popup1('无法连接到服务器');
                    });
                }
            });
		};
    };
	// 删除
	$scope.delIllegal = function() {
		if ($scope.checked.length == 0) {
            layer.msg('未选中数据！');
		} else {
			layer.confirm("确认要删除这" + $scope.checked.length
					+ "条吗?", {
				title: "提示",
			btn: ['确定', '取消'] //按钮
		}, function() {
                $scope.lopopup();
                var sysIdlist = [];
                angular.forEach($scope.checked, function(data,index) {
                    sysIdlist[index] = data.sysId;
                });
                var url = $scope.acheck.urls + ".action";
			$http({
				method : 'get',
				url : url,
				params : {
					sysIds : sysIdlist
				}, // 传递数据作为字符串，从前台传到后台
			}).success(function(data) {
				$scope.popup1('删除成功');
                $scope.shuaxin($scope.acheck);
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
});