    //创建vue对象
    var vue = new Vue({
        el:'#app',
        data:{
            biResultList:[]
        },
        methods:{
            findAll:function () {
                var _this = this;//this代表vue对象
                axios.get("/show/list").then(function (response) {
                    _this.biResultList=response.data;
                })
            }
        },
        //钩子事件调用findAll()方法
        created:function () {
            this.findAll();
        }
    });
