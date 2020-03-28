const app = new Vue({
  data:{
	  activities:[]
  },
  methods:{
	  	koufen_f(koufen){
	    	if(koufen){
	    		return "进行中";
	    	}else{
	    		return "已结束";
	    	}
	    },
	    koufen_(koufen){
	    	if(koufen){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    },
	    to_koufen(row){
	    	console.log(row);
	    	window.location.href = "/comment/koufen/"+row.id;  
	    }
  },
  mounted: function () {
	  axios.get('/comment/findAllKoufen')
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