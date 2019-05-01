package FDM1D;

// Area subclass extends Variable super class
// rachaitha: pkc

class Area extends Variable{

//...............constructor........................

Area(int[] Ns){
Nx=Ns[0];
Ny=Ns[1];
Nz=Ns[2];
value= new double[Nx][Ny][Nz];
}// x constructor

//..................method..........................

void setArea(Grid grid1,double DF_){
int i,j,k;
DF=DF_;
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++)
value[i][j][k]=1+2.2*Math.pow(grid1.x[i]-1.5,2);
}// x method setArea

void printArea(){
int i,j,k;
System.out.printf("\n  \nArea Data");
System.out.printf("\n  Dimensions  %d %d %d",Nx,Ny,Nz);
System.out.printf("\n  DF=%+-8.4f",DF);
System.out.printf("\n      i    j    k\t Area(ND)");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++)
System.out.printf("\n  %5d%5d%5d\t%+-8.4f",i,j,k,value[i][j][k]);
}// x method printArea

}// x class Area