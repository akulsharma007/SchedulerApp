angular.module("scheduleapp",[])
		.controller("func",func);

function func(){
	this.addvar;
	this.flag=false;
	this.arr=[];
	this.addfunc=function(){
		this.arr.push(this.addvar);
		this.addvar="";
	}

	this.removefunc=function(index){
		this.arr.splice(index,1);
	}

	this.editfunc=function(){
		this.flag=true;
	}

	this.savefunc=function(){
		this.flag=false;
	}

}