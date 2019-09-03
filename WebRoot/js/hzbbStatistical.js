//路口汇总统计
app.controller('hzbbStatisticalCtrl', function($scope, $http, $rootScope) {
    $scope.px_xh='xh';
    $scope.px_a='CJDZ';
    $scope.px_b='ZT';
    $scope.px_c='zqcount';
    $scope.px_d='zqacount';
    $scope.px_e='sfsfcount';
    $scope.px_f='mjscztcount';
    $scope.px_g='zqacountlv';
    $scope.px_h='sfshcountlv';
    $scope.px_i='mjscztcountlv';
    $scope.click_xh=function(){
        if($scope.px_xh=='xh'){
            $scope.px_xh='-xh';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }else{
            $scope.px_xh='xh';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }
    };
    $scope.click_a=function(){
        if($scope.px_a=='CJDZ'){
            $scope.px_xh='';$scope.px_a='-CJDZ';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }else{
            $scope.px_xh='';$scope.px_a='CJDZ';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }
    };
    $scope.click_b=function(){
        if($scope.px_b=='ZT'){
            $scope.px_xh='';$scope.px_a='';$scope.px_b='-ZT';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }else{
            $scope.px_xh='';$scope.px_a='';$scope.px_b='ZT';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }
    };
    $scope.click_c=function(){
        if($scope.px_c=='zqcount'){
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='-zqcount';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }else{
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='zqcount';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }
    };
    $scope.click_d=function(){
        if($scope.px_d=='zqacount'){
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='-zqacount';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }else{
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='zqacount';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }
    };
    $scope.click_e=function(){
        if($scope.px_e=='sfsfcount'){
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='-sfsfcount';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }else{
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='sfsfcount';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }
    };
    $scope.click_f=function(){
        if($scope.px_f=='mjscztcount'){
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='-mjscztcount';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }else{
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='mjscztcount';$scope.px_g='';$scope.px_h='';$scope.px_i='';
        }
    };
    $scope.click_g=function(){
        if($scope.px_g=='zqacountlv'){
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='-zqacountlv';$scope.px_h='';$scope.px_i='';
        }else{
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='zqacountlv';$scope.px_h='';$scope.px_i='';
        }
    };
    $scope.click_h=function(){
        if($scope.px_h=='sfshcountlv'){
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='-sfshcountlv';$scope.px_i='';
        }else{
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='sfshcountlv';$scope.px_i='';
        }
    };
    $scope.click_i=function(){
        if($scope.px_i=='mjscztcountlv'){
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='-mjscztcountlv';
        }else{
            $scope.px_xh='';$scope.px_a='';$scope.px_b='';$scope.px_c='';$scope.px_d='';$scope.px_e='';$scope.px_f='';$scope.px_g='';$scope.px_h='';$scope.px_i='mjscztcountlv';
        }
    };
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
            layer.closeAll();
            if(data.requst=="2"){
                $scope.items = data.data;
                $scope.pageSize = $scope.items.length-1;
            }else{
                console.log("失败");
            }
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
            document.getElementById("hzStatisticaa").download = "华为AI非现场执法平台数据统计("+(d2.getMonth()+1)+"-"+d2.getDate()+").xls";
        }
    })();
});