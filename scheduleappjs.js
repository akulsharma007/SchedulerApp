angular.module("scheduleapp",[])
		.controller("func",func);

function func($http){
	this.addvar;
	this.dbvar;
	this.flag=false;
	this.flagdb=false;
	this.arr=[];
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

	this.dbsave=function(){

		$http.post('http://localhost:3000/schedules',this.arr)
		.then(function(response){
			console.log("successfully saved");
		});
	}
}


