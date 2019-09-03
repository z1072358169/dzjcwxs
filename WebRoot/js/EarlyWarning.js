
app.filter('replacelukoustatus', function () {//过滤器
    return function (input) {
        switch(input)
        {
            case 1:return '正常'; break;
            case 2:return '预警'; break;
        }
    }
});
//路口汇总统计
app.controller('EarlyWarningCtrl', function($scope, $http, $rootScope) {
    //查询
    $scope.chaxunzts = function(){
        $scope.lopopup();
        $http({
            method : 'get',
            url : "http://41.5.252.9:8080/wxy/findD"
        }).success(function(data) {
            layer.closeAll();
            console.log(data);
            if(data.code==0){
                angular.forEach(data.data,function (d,i) {
                    if(d.updown==1){
                        d.color = "#0f0";
                        d.myVar = "img/upRate.png";
                    }else if(d.updown==2){
                        d.color = "#f00";
                        d.myVar = "img/downRate.png";
                    }else{
                        d.color = "#000";
                        d.myVar = "";
                    }
                    if(d.lukoustatus==1){
                        d.colory = "#000";
                    }else if(d.lukoustatus==2){
                        d.colory = "#f00";
                    }
                });
                $scope.iteamlist = data;
            }else{
                layer.msg(data.msg);
            }
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts();

});