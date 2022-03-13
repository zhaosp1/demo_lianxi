<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <hr />
    <p>普通文本插值：{{ message }}</p>
    <hr />
    <p v-html="temp"></p>
    <hr />
    <label for="r1">修改颜色</label>
    <input type="checkbox" v-model="use" id="r1" />
    <div v-bind:class="{'class1': use}">v-bind:class 指令</div>

    <div>
      {{5+5}}
      <br />
      {{ ok ? 'YES' : 'NO' }}
      <br />
      {{ message.split('').reverse().join('') }}
      <div v-bind:id="'list-' + id">JavaScript中文网</div>
    </div>

    <div>
      <p v-if="seen">现在你看到我了</p>
    </div>

    <div>
      <pre><a v-bind:href="url">JavaScript中文网</a></pre>
    </div>

    <div>
      <p>{{ message }}</p>
      <input v-model="message" />
    </div>

    <div>
      <button v-on:click="reverseMessage">反转字符串</button>
    </div>

    <div>{{ message | capitalize }}</div>

    <div>
      <ul>
        <li v-for="site in sites" :key="site">{{ site.name }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "test01",
  msg: "vue模板语法",
  props: {
    msg: String
  },

  data: function() {
    return {
      message: "vue模板语法",
      temp: "<h1>html文本：JavaScript中文网</h1>",
      use: false,
      ok: true,
      id: 1,
      seen: true,
      url: "http://www.javascriptcn.com",
      sites: [{ name: "JavaScript" }, { name: "Google" }, { name: "Taobao" }]
    };
  },
  methods: {
    reverseMessage: function() {
      this.message = this.message
        .split("")
        .reverse()
        .join("");
    }
  },
  filters: {
    capitalize: function(value) {
      if (!value) return "";
      value = value.toString();
      return value.charAt(0).toUpperCase() + value.slice(1);
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
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
.class1 {
  background: #444;
  color: #eee;
}
</style>
