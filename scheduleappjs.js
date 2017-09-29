angular.module("scheduleapp",[])
		.controller("func",func);

function func($http){
	var self=this;
	this.addvar;
	this.dbvar;
	this.flag=false;
	this.flagdb=false;
	this.flagupdate=false;
	this.arr=[];
	//this.temp=[1,2,3];
	self.getarrtask=[];
	this.tasktoget;
	this.addfunc=function(){
		this.arr.push(this.addvar);
		this.flagdb=true;
		this.addvar="";
	}

	this.removefunc=function(index){
		this.arr.splice(index,1);
		if(this.arr.length===0)
			this.flagdb=false;
	}

	this.editfunc=function(){
		this.flag=true;
	}

	this.donefunc=function(){
		this.flag=false;
	}

	this.updatefunc=function(){
		this.flagupdate=! this.flagupdate;
	}
	this.dbsave=function(){
		var obj={
    				"listOfTasks": this.arr,
    				"task": this.schdName
		};

		$http.post('http://localhost:8081/application/webapi/schedule',obj)
		.then(function(response){
			console.log("successfully saved");
		});
	}


	this.getfunc=function(){
		$http.get('http://localhost:8081/application/webapi/schedule/'+this.tasktoget)
			.then(function(response){
				self.getarrtask=response.data.listOfTasks;
			});
		}

	this.updatedbfunc=function(){
		console.log(self.getarrtask);
				var obj={
    				"listOfTasks": self.getarrtask,
    				"task": this.tasktoget
		};
		$http.put('http://localhost:8081/application/webapi/schedule/'+this.tasktoget,obj)
		.then(function(response){
			console.log(response);
		});
	}
}