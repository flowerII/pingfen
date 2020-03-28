const app = new Vue({
  data:{
	  user_name:null,
	  user_id:null,
	  activity_name:null,
	  activity_id:null,
	  team_name:null,
	  team_id:null,
	  items:[],
	  i_length:null,
	  models: Array(i_length).fill('')
  },
  methods:{
      onSubmit(){
    	  
    	  ////////////////
    	  let formData = new FormData();
    	  
          //下面是表单绑定的data 数据
          formData.append('user_id', this.user_id);
          formData.append('activity_id', this.activity_id);
          formData.append('team_id', this.team_id);
          formData.append('user_name', this.user_name);
          formData.append('activity_name', this.activity_name);
          formData.append('team_name', this.team_name);
          formData.append('models', this.models);
          let config = {
                  headers: {
                    'Content-Type': 'multipart/form-data'
                  }
              }
          axios.post('/activity/submit',formData, config).then(res => {
              // success callback
        	  //window.location.href='http://localhost:8081/index'
        	  ///activity/find_by_activityid?id='+a.id+'&amp;username='+username
        	  console.log('comment success!!');
        	  alert('提交成功！！');
        	  window.location.href='/activity/find_by_activityid?id='+this.activity_id+'&username='+this.user_name;
          }).catch(err => {
              // error callback
          });
    	  
      },
      select_item (index) {
         //把每一行的索引放进row
         console.log(this.models[index])
       }
  },
  mounted: function () {
	  this.user_name=document.getElementById('user_name').value;
	  this.user_id=document.getElementById('user_id').value;
	  this.activity_id=document.getElementById('activity_id').value;
	  this.activity_name=document.getElementById('activity_name').value;
	  this.team_id=document.getElementById('team_id').value;
	  this.team_name=document.getElementById('team_name').value;
	  this.i_length=document.getElementById('i_length').value;
	  axios.get('/activity/get_items', {
	    	params: {
	    		activity_id: document.getElementById('activity_id').value
		    }
		})
	  .then(response => (
		  this.items = response.data.list
		  //this.it_length=response.data.total
		  //console.log(response.data)
	  ))
	  .catch(function (error) {
	    console.log(error);
	  });
  }
}).$mount('#app')
 
// 现在，应用已经启动了！