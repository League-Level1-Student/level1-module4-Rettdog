int frogX = 200;
int frogY = 375;
int speed = 10;
Car car1 = new Car(400,70,100,3);
   Car car2 = new Car(-75,130,75,-2);
    Car car3 = new Car(400,300,50,5);
    Car car4 = new Car(-100,250,100,-3);

void setup(){
  size(400,400);
  
}
void draw(){
  background(111,111,111);
  fill(30,200,20);
  noStroke();
  ellipse(frogX,frogY,10,10);
  car1.move();
  car1.display();
  car2.move();
  car2.display();
  car3.move();
  car3.display();
  car4.move();
  car4.display();
  if(intersects(car1)){
    System.exit(0);
  }
  if(intersects(car2)){
    System.exit(0);
  }
  if(intersects(car3)){
    System.exit(0);
  }
  if(intersects(car4)){
    System.exit(0);
  }
  
  
}
void keyPressed()
{
      if(key == CODED){
            if(keyCode == UP)
            {
                  //Frog Y position goes up
                  frogY-=speed;
                  if(frogY<5){
                   frogY=5;
                   System.out.println("You win!");
                  }
            }
            else if(keyCode == DOWN)
            {
                  //Frog Y position goes down 
                  frogY+=speed;
                  if(frogY>395){
                   frogY=395; 
                  }
            }
            else if(keyCode == RIGHT)
            {
                  //Frog X position goes right
                  frogX+=speed;
                  if(frogX>395){
                   frogX=395; 
                  }
            }
            else if(keyCode == LEFT)
            {
                  //Frog X position goes left
                  frogX-=speed;
                  if(frogX<5){
                   frogX=5; 
                  }
            }
      }
}
public class Car{
  int x;
  int y;
  int size;
  int speed;
  Car(int x,int y,int size,int speed){
    this.x = x;
    this.y = y;
    this.size = size;
    this.speed = speed;
  }
  void display() {
      fill(0,0,0);
      rect(x , y, size, 50);
  }
  void move(){
    x+=speed;
    if(x>400){
     x=-100; 
    }else if(x<-100){
     x=400; 
    }
  }
  int getX(){
    return x;
  }
  int getY(){
    return y;
  }
  int getSize(){
    return size;
  }
  
}
boolean intersects(Car car1) {
      if ((frogY > car1.getY() && frogY < car1.getY()+50) && (frogX > car1.getX() && frogX < car1.getX()+car1.getSize()))
      {
             return true;
      }
      else 
      {
             return false;
      }
}