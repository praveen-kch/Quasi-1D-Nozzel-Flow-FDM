package FDM1D;

// Pressure class extends variable Superclass
// rachaitha: Pkc

class Pressure extends Variable{

//...............constructor.............
Pressure(int[] Ns){
Nx=Ns[0];
Ny=Ns[1];
Nz=Ns[2];
value= new double[Nx][Ny][Nz];
}// x constructor


//......................methods..............................

void setPressure(Temperature temp1, Density dens1, Material mat1){
int i,j,k;
DF=dens1.DF*temp1.DF*mat1.R;
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++)
value[i][j][k]=dens1.value[i][j][k]*temp1.value[i][j][k];
}// x method setPressure

void printPressure(){
int i,j,k;
System.out.printf("\n  \nPressure Data");
System.out.printf("\n  Dimensions  %d %d %d",Nx,Ny,Nz);
System.out.printf("\n  DF=%+-8.4f",DF);
System.out.printf("\n      i    j    k\tPressure");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++)
System.out.printf("\n %5d%5d%5d\t%+-8.4f",i,j,k,value[i][j][k]);
}// x method printPressure

}// x class Pressure
