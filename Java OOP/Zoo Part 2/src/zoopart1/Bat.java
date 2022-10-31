package zoopart1;

class Bat extends Mammal {
	public Bat(){
		this.energyLevel=300;
	}
	public void fly(){
		System.out.println("The sound of a bat taking off");
		this.energyLevel -=50;
	}
	public void eatHumans(){
		System.out.println("The so- well, never mind");
		this.energyLevel +=25;
	}
	public void attackTown(){
		System.out.println("The sound of a town on fire");
		this.energyLevel -=100;
	}

}
