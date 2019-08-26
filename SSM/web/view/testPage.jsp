<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spirng" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test.jsp</title>
    <%
        String contextPath = request.getContextPath();
        pageContext.setAttribute("ctp", contextPath);
    %>
    <script src="../js/jQuery-Core-1.12.4.js"></script>
    <script src="../js/toJSON.js"></script>
</head>

<body>

<h4>测试查询customer</h4>
<form action="${ctp}/myController/getCustomer">
    <p>
        <label>序号:
            <input type="text" name="id">
        </label>
    </p>
    <input type="submit" value="查询">
</form>

<hr>

<jstl:if test="${!empty requestScope.customer}">

    <spirng:form modelAttribute="customer" id="myForm">

        <input type="hidden" name="custId" value="${requestScope.customer.custId}">

        <p >
            序号 :${requestScope.customer.custId}
        </p>

        <p>
            <label for="name">姓名：</label>
            <spirng:input path="custName" name="custName" id="name"/>
        </p>

        <p>
            <label for="profession">职业：</label>
            <spirng:input path="custProfession" name="custProfession" id="profession"/>
        </p>

        <p>
            <label for="phone">手机：</label>
            <spirng:input path="custPhone" name="custPhone" id="phone"/>
        </p>

        <p>
            <label for="email">邮箱：</label>
            <spirng:input path="email" name="email" id="email"/>
        </p>

        <input type="submit" value="更新" id="formBtn">
        <input type="reset" name="重置">

    </spirng:form>

</jstl:if>


<script>
    $(function () {
        /*发送Ajax请求*/
        $("#formBtn").click(function () {
            //将form序列化为js对象
            var jsonData = $("#myForm").serializeJson();
            console.log(JSON.stringify(jsonData));
            $.ajax(
                {
                    type: "post",
                    url: "${ctp}/myController/updateCustomer",
                    //将js对象转为json字符串
                    data: JSON.stringify(jsonData),
                    //dataType规范了服务器返回值的类型，若不是json类型，会报错
                    // dataType: "text/html;charset=utf-8",
                    contentType: "application/json;charset=UTF-8",
                    success: function (data) {
                        console.log(data);
                        alert(data);
                    },
                    error: function (data) {
                        alert("服务器异常");
                    }
                }
            )
        })
    })
</script>


</body>
</html>
