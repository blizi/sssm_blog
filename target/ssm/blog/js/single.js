var v = new Vue({
    el:"#con_view",
    data:{
        id:'',
        result:'textarea-in',
        title:'',
        date:'',
        author:''
    },
    created() {
        var string = window.location.search;
        var uid = string.split('=')[1];
        console.log(uid),
        this.getContent(uid);
    },
    methods:{
        but_click:function(){
            console.log('dadadadadadadadadadadadada');
            v.result = "#### Disabled options\n" +
                "![](\\resource\\20190410\\164118\\109951163632406896.jpg)\n" +
                "\n" +
                "- TeX (Based on KaTeX);\n" +
                "- Emoji;\n" +
                "- Task lists;\n" +
                "- HTML tags decode;\n" +
                "- Flowchart and Sequence Diagram;\n" +
                "\n" +
                "#### Editor.md directory\n" +
                "\n" +
                "    editor.md/\n" +
                "            lib/\n" +
                "            css/\n" +
                "            scss/\n" +
                "            tests/\n" +
                "            fonts/\n" +
                "            images/\n" +
                "            plugins/\n" +
                "            examples/\n" +
                "            languages/     \n" +
                "            editormd.js\n" +
                "            ...\n" +
                "\n" +
                "```html\n" +
                "&lt;!-- English --&gt;\n" +
                "&lt;script src=\"../dist/js/languages/en.js\"&gt;&lt;/script&gt;\n" +
                "\n" +
                "&lt;!-- 繁體中文 --&gt;\n" +
                "&lt;script src=\"../dist/js/languages/zh-tw.js\"&gt;&lt;/script&gt;\n" +
                "```"
        },
        getContent:function (data) {
            axios.get('/getContent', {
                params: {
                    id:data
                }
            })
                .then(function (response) {
                    console.log(response.data);
                    v.title = response.data.title;
                    v.date = response.data.date;
                    v.result = response.data.content;
                    v.author = response.data.author;
                    console.log(v.result);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})
// var x = new Vue({
//     el:'#con_view',
//     data:{
//         title:'',
//         date:''
//     },
//     created() {
//         this.title = v.title;
//         this.date = v.date;
//     },
// })
