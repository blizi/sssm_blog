
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>Simple example - Editor.md examples</title>
    <link rel="stylesheet" href="/editor/examples/css/style.css"/>
    <link rel="stylesheet" href="/editor/css/editormd.css"/>
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
</head>
<body>
<div id="layout">
    <header>
        <h1>Simple example</h1>
    </header>
    <div id="test-editormd">
        <textarea style="display:none;"></textarea>
        <textarea class="editor-md-html" name="editor-md-html"></textarea>
    </div>
</div>
<script src="/editor/examples/js/jquery.min.js"></script>
<script src="/editor//editormd.min.js"></script>
<script type="text/javascript">
    var testEditor;

    $(function () {
        testEditor = editormd("test-editormd", {
            width: "70%",//编辑器大小官方默认90%
            height: 640,
            syncScrolling: "single",
            path: "/editor/lib/",
            saveHTMLToTextarea : true,//注意3：这个配置，textarea可以提交

            emoji: true,//emoji表情，默认关闭
            /**上传图片相关配置如下*/
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "/uploadFile",//注意你后端的上传图片服务地址
            onload: function () { //上传成功之后的回调

            },

            //editorTheme: "pastel-on-dark",//编辑器的主题颜色
            theme: "gray",//顶部的主题
            previewTheme: "dark"//显示的主题

        });

    });
</script>
</body>
</html>
