
/**
 * 数据展示页面分页插件的参数
 * cur 当前页
 * total 总页数
 * len   显示多少页数
 * pagesize 1页显示多少条数据
 * gourl 页码变化时 跳转的路径
 * targetId 分页插件作用的id
 */
var pageargs = {
    cur: 1,
    total: 0,
    len: 5,
    pagesize:10,
    gourl:"",
    targetId: 'pagination',
    callback: function (total) {
        var oPages = document.getElementsByClassName('page-index');
        for (var i = 0; i < oPages.length; i++) {
            oPages[i].onclick = function () {
                changePage(this.getAttribute('data-index'), pageargs.pagesize);
            }
        }
        var goPage = document.getElementById('go-search');
        goPage.onclick = function () {
            var index = document.getElementById('yeshu').value;
            if (!index || (+index > total) || (+index < 1)) {
                return;
            }
            changePage(index, pageargs.pagesize);
        }
    }
}

//数据展示页面分页插件的页码发送变化时执行
function changePage(pageNo,pageSize) {
    pageargs.cur=pageNo;
    pageargs.pagesize=pageSize;
    document.write("<form action="+pageargs.gourl +" method=post name=form1 style='display:none'>");
    document.write("<input type=hidden name='pageNum' value="+pageargs.cur+" >");
    document.write("<input type=hidden name='pageSize' value="+pageargs.pagesize+" >");
  
    document.write("</form>");
    document.form1.submit();
    pagination(pageargs);
}

