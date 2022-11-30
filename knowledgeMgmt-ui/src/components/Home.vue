<template>
    <div class="home">
        <h1>{{ msg }}</h1>
        <h2>this is home page!</h2>
        <div>
            <h1 @click="queryUserClick">
                查询user
            </h1>
        </div>
    </div>

</template>
  
<script>
export default {
    name: 'Home',
    data() {
        return {
            msg: 'welcome to knowledge management.'
        }
    },
    methods: {

        // queryUserClick: function(){
        //     this.
        // }
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
  