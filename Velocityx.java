package FDM1D;

// Velocityx subclass extends Variable super class
// rachaitha: pkc

class Velocityx extends Variable{

//...............constructor.................
Velocityx(int[] Ns){
Nx=Ns[0];
Ny=Ns[1];
Nz=Ns[2];
value= new double[Nx][Ny][Nz];
}// x constructor

//..................method...................
void setVelocityx(Grid grid1,Temperature temp1,double DF_){
int i,j,k;
DF=DF_;
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++)
value[i][j][k]=(0.1+1.09*grid1.x[i])*Math.sqrt(temp1.value[i][j][k]);
}// x method setvelocityx

void printVelocityx(){
int i,j,k;
System.out.printf("\n  \nVelocity Data");
System.out.printf("\n  Dimensions  %d %d %d",Nx,Ny,Nz);
System.out.printf("\n      i    j    k\tVelocity x");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++)
System.out.printf("\n  %5d%5d%5d\t%+-8.4f",i,j ,k,value[i][j][k]);
}// x printVelocityx

void dodtf(Density dens1,Temperature temp1,Material mat1, Area area1){
int i,j,k;
dt= new double[Nx][Ny][Nz];
//System.out.printf("\n  Time rate of change of Density Forward difference");
//System.out.printf("\n      i\t    j\t    k\t    d/dt");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++){
dt[i][j][k]=-value[i][j][k]*fdx[i][j][k]-(temp1.fdx[i][j][k]+(temp1.value[i][j][k]/dens1.value[i][j][k])*dens1.fdx[i][j][k])*(1/mat1.gamma);
//System.out.printf("\n  %5d\t%5d\t%5d\t%8.4f",i,j,k,dt[i][j][k]);
}
}// x dodt

void dodtb(Density dens2,Temperature temp2,Material mat1, Area area1){
int i,j,k;
dt= new double[Nx][Ny][Nz];
//System.out.printf("\n  Time rate of change of Density Forward difference");
//System.out.printf("\n      i\t    j\t    k\t    d/dt");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++){
dt[i][j][k]=-value[i][j][k]*bdx[i][j][k]-(temp2.bdx[i][j][k]+(temp2.value[i][j][k]/dens2.value[i][j][k])*dens2.bdx[i][j][k])*(1/mat1.gamma);
//System.out.printf("\n  %5d\t%5d\t%5d\t%8.4f",i,j,k,dt[i][j][k]);
}
}// x dodt

}// x class velocity
