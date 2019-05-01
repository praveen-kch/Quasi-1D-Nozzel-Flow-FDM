package FDM1D;

// Grid class for rectangular 3d grid data
// Rachaitha: Pkc

class Grid{

//..........................Variables......................

int  Nx, Ny, Nz;
double Lx,Ly,Lz;
double delx,dely,delz;
double[] x,y,z;

//..........................contructors...................

Grid(double[] Ls,int[] Ns){
int i;
Lx=Ls[0];
Ly=Ls[1];
Lz=Ls[2];
Nx=Ns[0];
Ny=Ns[1];
Nz=Ns[2];

x=new double[Nx];
y=new double[Ny];
z=new double[Nz];

if(Nx!=1) { delx=Lx/(Nx-1);} else {delx=0;}
for(i=0;i<Nx;i++)
x[i]=i*delx;

if(Ny!=1) { dely=Ly/(Ny-1);} else {dely=0;}
for(i=0;i<Ny;i++)
y[i]=i*dely;

if(Nz!=1) { delz=Lz/(Nz-1);} else {delz=0;}
for(i=0;i<Nz;i++)
z[i]=i*delz;

}// x constructor

//.........................methods.....................

void printGrid(){
int i;
System.out.printf("\n  \nGrid Data");
System.out.printf("\n  Nx=%d Ny=%d Nz=%d",Nx,Ny,Nz);
System.out.printf("\n  delx=%+-8.4f dely=%+-8.4f delz=%+-8.4f \n",delx,dely,delz);
System.out.printf("\n    i  \t  x");
for(i=0;i<Nx;i++)
System.out.printf("\n  %4d\t%+-8.4f",i,x[i]);
System.out.printf("\n");

System.out.printf("\n    j  \t  y");
for(i=0;i<Ny;i++)
System.out.printf("\n  %4d\t%+-8.4f",i,y[i]);
System.out.printf("\n");

System.out.printf("\n    k  \t  z");
for(i=0;i<Nz;i++)
System.out.printf("\n  %4d\t%+-8.4f",i,z[i]);
System.out.printf("\n");
}// x method printGrid

}// x class Grid