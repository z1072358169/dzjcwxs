var GserverURL = "/dzjc/";
var app = angular.module('synwork', [ 'ng', 'ngRoute','ngCookies']);
app.config(function($routeProvider) {
    $routeProvider.when('/wfList', {
            templateUrl : 'tpl/wfList.html',//违法抓拍查询
            controller : 'wfListCtrl'
        }).when('/User', {
        templateUrl : 'tpl/user.html',//用户查询
        controller : 'userCtrl'
    }).when('/addUser', {
        templateUrl : 'tpl/adduser.html',//用户添加
        controller : 'addUserCtrl'
    }).when('/updateUser', {
        templateUrl : 'tpl/updateuser.html',//用户修改
        controller : 'updUserCtrl'
    }).when('/sec', {
        templateUrl : 'tpl/sec.html',//部门
        controller : 'secCtrl'
    }).when('/addsec', {
        templateUrl : 'tpl/addsec.html',//部门添加
        controller : 'addsecCtrl'
    }).when('/updatesec', {
        templateUrl : 'tpl/updatesec.html',//部门修改
        controller : 'updsecCtrl'
    }).when('/perInfo', {
        templateUrl : 'tpl/perInfo.html',//个人信息
        controller : 'perInfoCtrl'
    }).when('/Role', {
        templateUrl : 'tpl/role.html',//角色查询
        controller : 'roleCtrl'
    }).when('/addRole', {
        templateUrl : 'tpl/addrole.html',//角色添加
        controller : 'addroleCtrl'
    }).when('/updateRole', {
        templateUrl : 'tpl/updaterole.html',//角色修改
        controller : 'updroleCtrl'
    }).when('/special', {
        templateUrl : 'tpl/special.html',//特殊车牌查询
        controller : 'specialCtrl'
    }).when('/datafenpei', {
        templateUrl : 'tpl/datafenpei.html',//数据分配
        controller : 'datafenpeiCtrl'
    }).when('/dataManagement', {
        templateUrl : 'tpl/dataManagement.html',//数据管理
        controller : 'dataManagementCtrl'
    }).when('/wfStatistics', {
        templateUrl : 'tpl/wfStatistics.html',//筛选统计
        controller : 'wfStatisticsCtrl'
    }).when('/RoadStatistical', {
        templateUrl : 'tpl/RoadStatistical.html',//路口数据统计
        controller : 'RoadStatisticalCtrl'
    }).when('/mjwfList', {
        templateUrl : 'tpl/mjwfList.html',//民警违法初筛
        controller : 'mjwfListCtrl'
    }).when('/mspecial', {
        templateUrl : 'tpl/mspecial.html',//民警初筛查询
        controller : 'mspecialCtrl'
    }).when('/mjwfStatistics', {
        templateUrl : 'tpl/mjwfStatistics.html',//民警筛选统计
        controller : 'mjwfStatisticsCtrl'
    }).when('/holle', {
        templateUrl : 'tpl/holle.html'//欢迎页
    }).when('/hzStatistical', {
        templateUrl : 'tpl/hzStatistical.html',//路口汇总统计
        controller : 'hzStatisticalCtrl'
    }).when('/hzbbStatistical', {
        templateUrl : 'tpl/hzbbStatistical.html',//路口数据报表
        controller : 'hzbbStatisticalCtrl'
    }).when('/PointManagement', {
        templateUrl : 'tpl/PointManagement.html',//路口管理
        controller : 'PointManagementCtrl'
    }).when('/ScrapScreen', {
        templateUrl : 'tpl/ScrapScreen.html',//废片筛选
        controller : 'ScrapScreenCtrl'
    }).when('/ScrapQuery', {
        templateUrl : 'tpl/ScrapQuery.html',//废片筛选查询
        controller : 'ScrapQueryCtrl'
    }).when('/ScrapStatistics', {
        templateUrl : 'tpl/ScrapStatistics.html',//废片筛选统计
        controller : 'ScrapStatisticsCtrl'
    }).when('/EarlyWarning', {
        templateUrl : 'tpl/EarlyWarning.html',//路口分析
        controller : 'EarlyWarningCtrl'
    }).otherwise({
        redirectTo : '/RoadStatistical'
    })

});

//主页控制器
app.controller('parentCtrl', function($scope, $rootScope, $http) {
    //loading弹窗
    $scope.lopopup = function(){
        layer.load(1, {
            shade: [0.3, '#393D49']
        });
    };
    //跳转弹窗
    $scope.popup = function(url,name){
        layer.closeAll('loading');
        layer.open({
            type: 1,
            title: "提示",
            closeBtn: 0,
            content: '<div style="padding: 20px 80px;">' + name + '</div>',
            btn: '确定',
            btnAlign: 'c',
            yes: function() {
                window.location = url;
                layer.closeAll();
            },
            end: function() {
                window.location = url;
                layer.closeAll();
            }
        });
    };
    //提示信息弹框
    $scope.popup1 = function(name){
        layer.open({
            type: 1,
            title: "提示",
            closeBtn: 0,
            content: '<div style="padding: 20px 80px;">' + name + '</div>',
            btn: '确定',
            btnAlign: 'c',
            end: function() {
                layer.closeAll('loading');
            }
        });
    };
    //分页
    $scope.fenyeq = function(datax) {
        $scope.data = datax;
        //分页总数
        $scope.pageSize = 15;
        $scope.zongshu = $scope.data.length;
        $scope.pages = Math.ceil($scope.data.length / $scope.pageSize); //分页数
        $scope.newPages = $scope.pages > 5 ? 5 : $scope.pages;
        $scope.pageList = [];
        $scope.selPage = 1;
        //设置表格数据源(分页)
        $scope.setData = function() {
            $scope.items = $scope.data.slice(($scope.pageSize * ($scope.selPage - 1)), ($scope.selPage * $scope.pageSize)); //通过当前页数筛选出表格当前显示数据
        }
        $scope.items = $scope.data.slice(0, $scope.pageSize);
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

    $scope.jump = function(arg) {
        $location.path(arg)
    };
    $scope.states = {};

});

//登陆
app.controller('loginCtrl', function($scope, $rootScope, $http, $cookieStore) {
    var login_long = 0;
    /*$scope.getLoginInfo = function(){
        var abb = {
            "userNum" : 1,
            "userName" : 111,
            "permissions" :2,
            "roleName":1,
            "passWord":1
        };
        $cookieStore.put("person",abb);//设置cookie
        window.location = "synwork.html";
    };*/
    $scope.denglupd = function (dat){
        if (login_long == 0){
            login_long = 1;
            $scope.getLoginInfo(dat);
        }else{
            console.log(login_long)
        }
    };
    $scope.getLoginInfo = function(pow) {
        layer.load(1, {
            shade: [0.3, '#393D49']
        });
        if(pow){
            $scope.name = $scope.name1;
            $scope.pw = $scope.pw1;
        }else{
            $scope.name = $scope.name2;
            $scope.pw = $scope.pw2;
        };
        if ($scope.name == null || $scope.name == "") {
            layer.open({
                type: 1,
                title: "提示",
                closeBtn: 0,
                content: '<div style="padding: 20px 80px;">请输入账号</div>',
                btn: '确定',
                btnAlign: 'c',
                end: function() {
                    login_long = 0;
                    layer.closeAll('loading');
                }
            });
        } else if ($scope.pw == null || $scope.pw == "") {
            layer.open({
                type: 1,
                title: "提示",
                closeBtn: 0,
                content: '<div style="padding: 20px 80px;">请输入密码</div>',
                btn: '确定',
                btnAlign: 'c',
                end: function() {
                    login_long = 0;
                    layer.closeAll('loading');
                }
            });
        } else {
            $http({
                method : 'get',
                url : GserverURL + "login.action",
                params : {
                    userOA : $scope.name,
                    phone : $scope.name,
                    passWord : $scope.pw
                }, // 传递数据作为字符串，从前台传到后台
            }).success(function(data) {
                if (data == 1||data=="") {
                    layer.open({
                        type: 1,
                        title: "提示",
                        closeBtn: 0,
                        content: '<div style="padding: 20px 80px;">账号或密码错误</div>',
                        btn: '确定',
                        btnAlign: 'c',
                        end: function() {
                            login_long = 0;
                            layer.closeAll('loading');
                        }
                    });
                } else {
                    if(pow){
                        if(data[0].permissions.wfcs){
                            var abb = {
                                "userNum" : data[0].userNum,
                                "userName" : data[0].userName,
                                "userId" : data[0].userId,
                                "secId" : data[0].secId,
                                "secName" : data[0].secName,
                                "permissions" :data[0].permissions,
                                "roleName":data[0].roleName,
                                "passWord":data[0].passWord
                            };
                            login_long = 0;
                            layer.closeAll('loading');
                            $cookieStore.put("person",abb);//设置cookie
                            window.location = "synwork.html#/wfList";
                        }else{
                            layer.open({
                                type: 1,
                                title: "提示",
                                closeBtn: 0,
                                content: '<div style="padding: 20px 80px;">请在初筛复核中登陆</div>',
                                btn: '确定',
                                btnAlign: 'c',
                                end: function() {
                                    login_long = 0;
                                    layer.closeAll('loading');
                                }
                            });
                        }
                    }else{
                        if(data[0].permissions.mwfcs){
                            var abb = {
                                "userNum" : data[0].userNum,
                                "userName" : data[0].userName,
                                "userId" : data[0].userId,
                                "secId" : data[0].secId,
                                "secName" : data[0].secName,
                                "permissions" :data[0].permissions,
                                "roleName":data[0].roleName,
                                "passWord":data[0].passWord
                            };
                            login_long = 0;
                            layer.closeAll('loading');
                            $cookieStore.put("person",abb);//设置cookie
                            window.location = "synwork.html#/mjwfList";
                        }else{
                            layer.open({
                                type: 1,
                                title: "提示",
                                closeBtn: 0,
                                content: '<div style="padding: 20px 80px;">请在违法初筛中登陆</div>',
                                btn: '确定',
                                btnAlign: 'c',
                                end: function() {
                                    login_long = 0;
                                    layer.closeAll('loading');
                                }
                            });
                        }
                    };
                }
            }).error(function() {
                layer.open({
                    type: 1,
                    title: "提示",
                    closeBtn: 0,
                    content: '<div style="padding: 20px 80px;">无法连接到服务器</div>',
                    btn: '确定',
                    btnAlign: 'c',
                    end: function() {
                        login_long = 0;
                        layer.closeAll('loading');
                    }
                });
            });
        }
    }
});

app.controller('headerCtrl', function($scope, $rootScope, $cookieStore,$http,$location) {
    $scope.person = $cookieStore.get("person");
    if ($scope.person == null || $scope.person == ""){
        $cookieStore.remove("person");
        window.location = "index.html";
    };

    $scope.tuichu = function(){
        if ($scope.person.permissions.mwfcs){
            $http({
                method : 'get',
                url : "updateghdatamjnew.action",
                params:{
                    mjuserName:$scope.person.userName
                }
            }).success(function(data) {
            	console.log(data);
            }).error(function() {
                $scope.popup1('无法连接到服务器');
            });
		}
        $cookieStore.remove("person");
        window.location = "index.html";

        // if ($scope.person.permissions.mwfcs){
        //     var url = "updateghdatamjnew.action";
        // }else {
        //     var url = "updateghdata.action";
        // }
        // $scope.lopopup();
        // $http({
        //     method : 'get',
        //     url : url,
        //     params:{
        //         userName:$scope.person.userName
        //     }
        // }).success(function(data) {

        // }).error(function() {
        //     $scope.popup1('无法连接到服务器');
        // });
	};
    $scope.perInfo = function(){
        $rootScope.perInfourl = $location.url();
        $location.path("/perInfo");
    };
});
app.controller('asideCtrl', function($scope, $rootScope, $cookieStore) {
    $scope.person = $cookieStore.get("person");
    if ($scope.person == null || $scope.person == ""){
        $cookieStore.remove("person");
        window.location = "index.html";
    };
});
app.controller('datafenpeiCtrl', function($http,$scope, $rootScope, $cookieStore) {
    $scope.person = $cookieStore.get("person");
    if ($scope.person == null || $scope.person == ""){
        $cookieStore.remove("person");
        window.location = "index.html";
    };
    $scope.data_cc = "";
    $scope.data_c = "";
    $http({
        method : 'GET',
        url : "queryUser.action",
        // 传递数据作为字符串，从前台传到后台
    }).success(function(data) {
        $scope.userlist = data;
    }).error(function() {
        $scope.popup1("服务器连接失败");
    });
    //查询
    $http({
        method : 'get',
        url : "queryAll.action"
    }).success(function(data) {
        $scope.params = data[0];
    }).error(function() {
        $scope.popup1('无法连接到服务器');
    });
    $scope.example = function(){
        $http({
            method : 'get',
            url : "findAddress.action",
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
    $scope.dqy = 1;
    $scope.cqzs = "30";
    $scope.fpzhuangtai = '1';
    $scope.pageSize = '';
    $scope.items = '';
    $scope.example();
    $scope.chaxunzts = function(){
        //console.log($scope.data_c);

        $scope.starttime = $("#starttime").val();
        $scope.endtime = $("#endtime").val();
        $http({
            method : 'get',
            url : "getCountfpName.action",
            params:{
                userName:$scope.fpzhuangtai,
                HPZL:$scope.data_a,//号牌种类
                HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$scope.starttime,//开始时间
                endTime:$scope.endtime,//结束时间
                WFDM:$scope.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                area:$scope.data_f,//区域
                SFSH:-1
            }
        }).success(function(data) {
            $scope.pageSize = data;
            $scope.chaxun();
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxun = function(){
        $http({
            method : 'get',
            url : "findPageByfpName.action",
            params:{
                userName:$scope.fpzhuangtai,
                HPZL:$scope.data_a,//号牌种类
                HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$scope.starttime,//开始时间
                endTime:$scope.endtime,//结束时间
                WFDM:$scope.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                area:$scope.data_f,//区域
                SFSH:-1,
                pageSize:$scope.cqzs,//抽取条数
                pageNow:$scope.dqy//当前页
            }
        }).success(function(data) {
            $scope.fengyez(data);
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    //分页
    $scope.setData = function() {
        $http({
            method : 'get',
            url : "findPageByfpName.action",
            params:{
                userName:$scope.fpzhuangtai,
                HPZL:$scope.data_a,//号牌种类
                HPYS:$scope.data_b,//号牌颜色
                HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                CJDZ:$('#exampledata1').val(),//违法地点
                startTime:$scope.starttime,//开始时间
                endTime:$scope.endtime,//结束时间
                WFDM:$scope.data_d,//违法行为
                FXBH:$scope.data_e,//方向
                area:$scope.data_f,//区域
                SFSH:-1,
                pageSize:$scope.cqzs,//抽取条数
                pageNow:$scope.dqy//当前页
            }
        }).success(function(data) {
            $scope.items = data;
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
    $scope.pagesizefp = "";
    //判断数字
    $scope.panduanshuzi = function(){
        if($scope.pageSize==""){
            layer.msg('还未查询数据');
            $scope.pagesizefp = "";
        }else if($scope.pagesizefp === "" || $scope.pagesizefp ==null){
            layer.msg('只能填写数字');
            $scope.pagesizefp = "";
        }else if(isNaN($scope.pagesizefp)){
            layer.msg('只能填写数字');
            $scope.pagesizefp = "";
        }else if(Number($scope.pagesizefp)>Number($scope.pageSize)){
            layer.msg('必须小于数据总量');
            $scope.pagesizefp = "";
        }
    };
    //分配数据
    $scope.fenpeidata = function(){
        //var userna = JSON.parse($scope.userName);
        if($scope.pagesizefp==""){
            layer.msg('未填写提取条数!');
        }else{
            $http({
                method : 'get',
                url : "updateStatuefpName.action",
                params:{
                    HPZL:$scope.data_a,//号牌种类
                    HPYS:$scope.data_b,//号牌颜色
                    HPHM:$scope.data_cc+$scope.data_c,//号牌号码
                    CJDZ:$('#exampledata1').val(),//违法地点
                    startTime:$scope.starttime,//开始时间
                    endTime:$scope.endtime,//结束时间
                    WFDM:$scope.data_d,//违法行为
                    FXBH:$scope.data_e,//方向
                    area:$scope.data_f,//区域
                    SFSH:-1,
                    userName:$scope.person.userName,
                    userId:$scope.person.userId,
                    pageSize:$scope.pagesizefp
                }
            }).success(function(data) {
                $scope.popup1(data);
                $scope.chaxunzts();
                $scope.pagesizefp = "";
            }).error(function() {
                $scope.popup1('无法连接到服务器');
            });
        };
    };

    //释放数据
    $scope.shifangdata = function(){
        //var userna = JSON.parse($scope.userName);
        $http({
            method : 'get',
            url : "updateghdata.action",
            params:{
                userName:$scope.person.userName
            }
        }).success(function(data) {
            $scope.popup1(data);
            $scope.chaxunzts();
            $scope.pagesizefp = "";
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
});