<template>
    <div class="home">
        <h1>{{ msg }}</h1>
        <h2>this is home page!</h2>
        <div>
            <h1 @click="queryUserClick">
                查询user
            </h1>

            <button @click="queryUserClick">查询</button>
            <h2>{{ id }}</h2>
        </div>
    </div>

</template>
  
<script>
export default {
    name: 'Home',
    data() {
        return {
            msg: 'welcome to knowledge management.',
            id: 'default'
        }
    },
    methods: {

        queryUserClick: function(){
            var _this = this;
            console.log("ddd");
            this.postRequest("/kgms/user", {"id":1})
            .then(resp=> {
                //   _this.loading = false;
                if (resp && resp.status == 200) {
                    _this.id = resp.data.id;
                    // _this.$store.commit('login', data.obj);
                    // var path = _this.$route.query.redirect;
                    // _this.$router.replace({path: path == '/' || path == undefined ? '/home' : path});
                }
            })
            console.log("fff");
        }
    }
}
</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
    font-weight: normal;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    display: inline-block;
    margin: 0 10px;
}

a {
    color: #42b983;
}
</style>
  