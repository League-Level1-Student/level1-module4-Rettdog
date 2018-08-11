int frogX = 200;
int frogY = 375;
int speed = 10;


void setup(){
  size(400,400);
}
void draw(){
  background(111,111,111);
  fill(30,200,20);
  noStroke();
  ellipse(frogX,frogY,50,50);
}
void keyPressed()
{
      if(key == CODED){
            if(keyCode == UP)
            {
                  //Frog Y position goes up
                  frogY-=speed;
                  if(frogY<25){
                   frogY=25; 
                  }
            }
            else if(keyCode == DOWN)
            {
                  //Frog Y position goes down 
                  frogY+=speed;
                  if(frogY>375){
                   frogY=375; 
                  }
            }
            else if(keyCode == RIGHT)
            {
                  //Frog X position goes right
                  frogX+=speed;
                  if(frogX>375){
                   frogX=375; 
                  }
            }
            else if(keyCode == LEFT)
            {
                  //Frog X position goes left
                  frogX-=speed;
                  if(frogX<25){
                   frogX=25; 
                  }
            }
      }
}
public void Car(){
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
  
}