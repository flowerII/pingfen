const app = new Vue({
  data:{
	  activities:[]
  },
  methods:{
	    koufen_(koufen){
	    	if(koufen){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    },
	    to_paiming(row){
	    	console.log(row);
	    	window.location.href = '/comment/rank/'+row.id;  
	      }
  },
  mounted: function () {
	  axios.get('/comment/findAllActivity')
	  .then(response => (
		  this.activities = response.data.list
		  //console.log(response.data)
	  ))
	  .catch(function (error) {
	    console.log(error);
	  });
  }
}).$mount('#app')
 
// 现在，应用已经启动了！