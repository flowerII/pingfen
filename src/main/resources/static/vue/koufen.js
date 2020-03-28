const app = new Vue({
  data:{
	  items:[],
	  activity_name: null,
	  activity_id: null,
	  i_length:null,
	  models: Array(i_length).fill('')
  },
  methods:{
	  koufenShow(koufen){
	    	if(koufen > 0){
	    		return false;
	    	}else if(koufen<=0){
	    		return true;
	    	}
	    },
      onSubmit(){
    	  
    	  ////////////////
    	  let formData = new FormData();
    	  
          //下面是表单绑定的data 数据
          formData.append('activity_id', this.activity_id);
          formData.append('models', this.models);
          console.log(formData);
          let config = {
                  headers: {
                    'Content-Type': 'multipart/form-data'
                  }
              }
          axios.post('/comment/koufen_submit',formData, config).then(res => {
              // success callback
        	  //window.location.href='http://localhost:8081/index'
        	  ///activity/find_by_activityid?id='+a.id+'&amp;username='+username
        	  console.log('comment success!!');
        	  alert('提交成功！！');
        	  window.location.href='/';
          }).catch(err => {
              // error callback
          });
    	  
      }
  },
  mounted: function () {
	  this.i_length=document.getElementById('i_length').value;
	  this.activity_name=document.getElementById('activity_name').value;
	  this.activity_id=document.getElementById('activity_id').value;
	  axios.get('/comment/get_koufen_team', {
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