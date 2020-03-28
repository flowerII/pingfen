const app = new Vue({
  data:{
	  items:[],
	  activity_name: null,
	  activity_avg: null,
	  activity_koufen: null,
	  activity_id: null
  },
  methods:{
	  
  },
  mounted: function () {
	  this.activity_name=document.getElementById('activity_name').value;
	  this.activity_id=document.getElementById('activity_id').value;
	  this.activity_avg=document.getElementById('activity_avg').value;
	  this.activity_koufen=document.getElementById('activity_koufen').value;
	  axios.get('/comment/rank_data', {
	    	params: {
	    		id: document.getElementById('activity_id').value
		    }
		})
	  .then(response => (
		  this.items = response.data.list,
		  //this.it_length=response.data.total
		  console.log(response.data)
	  ))
	  .catch(function (error) {
	    console.log(error);
	  });
  }
}).$mount('#app')
 
// 现在，应用已经启动了！