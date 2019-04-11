var con = new Vue({
    el:"#content",

    data:{
        content:[]
    },
    created() {
        axios.get('/userContent', {
            params: {
              id:1
            }
          })
          .then(function (response) {
             con.content = response.data;
          })
          .catch(function (error) {
            console.log(error);
          }); 
    },
    methods:{
        content_view:function (data) {
            console.log(data);
            window.open('/blog/single.html?id='+data);
        }
    }
})