<template>
    <!-- <div class="home">
        <h1>{{ msg }}</h1>
        <h2>this is home page!</h2>
        <div>
            <h1 @click="queryUserClick">
                查询user
            </h1>

            <button @click="queryUserClick">查询</button>
            <h2>{{ id }}</h2>
        </div>
    </div> -->

    <div>
        <el-form :rules="rules" class="login-container" label-position="left" :model="userForm" label-width="0px"
            v-loading="loading">


            <!-- <h1>{{ msg }}</h1>
            <h2>this is home page!</h2>
            <h1 @click="queryUserClick">
                查询user
            </h1>
            <button @click="queryUserClick">查询</button>
            <h2>{{ id }}</h2> -->






            <h3 class="login_title">用户查询</h3>
            <el-form-item label="请输入用户ID:" prop="id" label-width="120px">
                <el-input type="text" v-model="userForm.id" auto-complete="off" placeholder="ID"></el-input>
            </el-form-item>
            <!-- <el-form-item prop="password">
                <el-input type="password" v-model="userForm.password" auto-complete="off" placeholder="密码"></el-input>
            </el-form-item> -->
            <!-- <el-checkbox class="login_remember" v-model="checked" label-position="left">记住密码</el-checkbox> -->
            <el-form-item style="width: 100%">
                <el-button type="primary" style="width: 100%" @click="queryUserClick">查询</el-button>
            </el-form-item>

            <!-- <el-form-item label="firstName" prop="firstName" label-width="100px">
                <el-input type="firstName" v-model="userForm.firstName" auto-complete="off"
                    placeholder="firstName"></el-input>
            </el-form-item> -->

            <!-- 表单列表 -->

            <el-table :data="userList" style="width: 100%">
                <el-table-column prop="id" label="id" width="180">
                </el-table-column>
                <el-table-column prop="firstName" label="姓氏" width="180">
                </el-table-column>
                <el-table-column prop="lastName" label="名字">
                </el-table-column>
            </el-table>



            <h3 class="login_title">新建用户</h3>
            <!-- <el-form-item label="id" prop="id" label-width="100px">
                <el-input type="text" v-model="userForm.id" auto-complete="off" placeholder="ID"></el-input>
            </el-form-item> -->
            <el-form-item label="firstName" prop="firstName" label-width="100px">
                <el-input type="text" v-model="userForm.firstName" auto-complete="off"
                    placeholder="firstName"></el-input>
            </el-form-item>
            <el-form-item label="lastName" prop="lastName" label-width="100px">
                <el-input type="text" v-model="userForm.lastName" auto-complete="off" placeholder="lastName"></el-input>
            </el-form-item>
            <el-form-item style="width: 100%">
                <el-button type="primary" style="width: 100%" @click="createUserClick">创建用户</el-button>
            </el-form-item>

        </el-form>
    </div>



</template>
  
<script>
export default {
    name: 'Home',
    data() {
        return {
            msg: 'welcome to knowledge management.',
            // id: 'default',

            rules: {
                id: [{ required: true, message: '请输入id', trigger: 'blur' }],
                content: [{ required: true, message: 'default', trigger: 'blur' }]
            },
            checked: true,
            userForm: {
                id: '1599019351640506368',
                firstName: 'firstName',
                lastName: 'lastName'
            },
            loading: false,

            userList: []
        }
    },
    methods: {

        queryUserClick: function () {
            var _this = this;
            console.log("ddd");
            this.postRequest("/kgms/user", _this.userForm)
                .then(resp => {
                    //   _this.loading = false;
                    if (resp && resp.status == 200) {
                        _this.userForm.id = resp.data.id;

                        _this.userForm.firstName = resp.data.firstName;

                        _this.userList = [resp.data];
                        // _this.$store.commit('login', data.obj);
                        // var path = _this.$route.query.redirect;
                        // _this.$router.replace({path: path == '/' || path == undefined ? '/home' : path});
                    }
                })
            console.log("fff");
        },

        createUserClick: function () {
            var _this = this;
            console.log("start createUserClick");
            this.postRequest("/kgms/createUser", _this.userForm)
                .then(resp => {
                    if (resp && resp.status == 200) {
                        console.log("create user success.");
                        // _this.id = resp.data.id;

                        // _this.userForm.content = resp.data.firstName;

                    }
                });
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
  