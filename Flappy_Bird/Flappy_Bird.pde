int x =100;
int y = 100;
int pipeM = 200;
int pipeX = 500;
//int pipeY = pipeM+50;
int pipeH = 400;
int pipe2Y = 0;
//int pipe2H = pipeM-50;
int velocity = 30;
int gravity = 1;
int score = 0;
void setup(){
  size(500,400);
  
}
void draw(){
  background(20,100,200);
  
  fill(0,250,0);
  //bottom
  rect(pipeX,pipeM+50,75,pipeH);
  //top
  rect(pipeX,pipe2Y,75,pipeM-50);
  fill(150,10,10);
  noStroke();
  ellipse(x,y,50,50);
  text(score, 10, 10);
  if(intersectsPipes()){
    System.exit(0);
  }
  y+=gravity;
  pipeX-=2;
 if(pipeX==0){
   score++;
 }
  if(pipeX<-75){
   teleportPipe(); 
  }
}
void mousePressed(){
  y-=velocity;
}
void teleportPipe(){
  pipeM = (int) random(50,350);
 pipeX =500; 
}
boolean intersectsPipes() { 
   
     if(y<25||y>375){
      return true; 
     }
     
     if(y-25<pipeM-50){
       if(x+25>pipeX&&x-25<pipeX+75){
         return true;
       }
     }else if(y+25>pipeM+50){
       if(x+25>pipeX&&x-25<pipeX+75){
         return true;
       }
     }else{
      return false; 
     }
     return false;
}