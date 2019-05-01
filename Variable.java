package FDM1D;

// Variable super class
// lekari: pkc

class Variable{

//..................................Variabels.............................
int Nx,Ny,Nz,Nc;
double DF;
double[][][] value;
double[][][] fdx,fdy,fdz,bdx,bdy,bdz,dt,lnfdx,lnfdy,lnfdz,lnbdx,lnbdy,lnbdz;
int[][] conNodes;
double[][] cons;
//................................. constructors ............................

Variable(){
}// x constructor1

Variable(int[] Ns){
Nx=Ns[0];
Ny=Ns[1];
Nz=Ns[2];
value= new double[Nx][Ny][Nz];
Nc=0;
}// x constructor2


//................................. methods .................................
void fwddiffcalc(Grid grid1){
int i,j,k;
fdx= new double[Nx][Ny][Nz];
fdy= new double[Nx][Ny][Nz];
fdz= new double[Nx][Ny][Nz];
//System.out.printf("\n  \n Forward Difference");
//System.out.printf("\n      i\t    j\t    k\t   fdx  \t   fdy  \t   fdz  ");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++){
//System.out.printf("\n  %5d\t%5d\t%5d",i,j,k);
if (i!=(Nx-1))
fdx[i][j][k]=(value[i+1][j][k]-value[i][j][k])/(grid1.x[i+1]-grid1.x[i]); 
else
fdx[i][j][k]=0;
if (j!=(Ny-1))
fdy[i][j][k]=(value[i][j+1][k]-value[i][j][k])/(grid1.y[j+1]-grid1.y[j]);
else
fdy[i][j][k]=0;
if (k!=(Nz-1))
fdz[i][j][k]=(value[i][j][k+1]-value[i][j][k])/(grid1.z[k+1]-grid1.z[k]);
else
fdz[i][j][k]=0;
//System.out.printf("\t%8.4f\t%8.4f\t%8.4f",fdx[i][j][k],fdy[i][j][k],fdz[i][j][k]);
}
}// x method fwddiffcalc

void bwddiffcalc(Grid grid1){
int i,j,k;
bdx= new double[Nx][Ny][Nz];
bdy= new double[Nx][Ny][Nz];
bdz= new double[Nx][Ny][Nz];
//System.out.printf("\n  \n Backward Difference");
//System.out.printf("\n      i\t    j\t    k\t   bdx  \t   bdy  \t   bdz  ");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++){
//System.out.printf("\n  %5d\t%5d\t%5d",i,j,k);
if (i!=0)
bdx[i][j][k]=(value[i][j][k]-value[i-1][j][k])/(grid1.x[i]-grid1.x[i-1]); 
else
bdx[i][j][k]=0;
if (j!=0)
bdy[i][j][k]=(value[i][j][k]-value[i][j-1][k])/(grid1.y[j]-grid1.y[j-1]); 
else
bdy[i][j][k]=0;
if (k!=0)
bdz[i][j][k]=(value[i][j][k]-value[i][j][k-1])/(grid1.z[k]-grid1.z[k-1]); 
else
bdz[i][j][k]=0;
//System.out.printf("\t%8.4f\t%8.4f\t%8.4f",bdx[i][j][k],bdy[i][j][k],bdz[i][j][k]);
}
}// x method bwddiffcalc

void lnfwddiffcalc(Grid grid1){
int i,j,k;
lnfdx= new double[Nx][Ny][Nz];
lnfdy= new double[Nx][Ny][Nz];
lnfdz= new double[Nx][Ny][Nz];
//System.out.printf("\n  \n Forward Difference");
//System.out.printf("\n      i\t    j\t    k\t lnfdx  \t lnfdy  \t lnfdz  ");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++){
//System.out.printf("\n  %5d\t%5d\t%5d",i,j,k);
if (i!=(Nx-1))
lnfdx[i][j][k]=(Math.log(value[i+1][j][k])-Math.log(value[i][j][k]))/(grid1.x[i+1]-grid1.x[i]); 
else
lnfdx[i][j][k]=0;
if (j!=(Ny-1))
lnfdy[i][j][k]=(Math.log(value[i][j+1][k])-Math.log(value[i][j][k]))/(grid1.y[j+1]-grid1.y[j]);
else
lnfdy[i][j][k]=0;
if (k!=(Nz-1))
lnfdz[i][j][k]=(Math.log(value[i][j][k+1])-Math.log(value[i][j][k]))/(grid1.z[k+1]-grid1.z[k]);
else
lnfdz[i][j][k]=0;
//System.out.printf("\t%8.4f\t%8.4f\t%8.4f",lnfdx[i][j][k],lnfdy[i][j][k],lnfdz[i][j][k]);
}
}// x method fwddiffcalc

void lnbwddiffcalc(Grid grid1){
int i,j,k;
lnbdx= new double[Nx][Ny][Nz];
lnbdy= new double[Nx][Ny][Nz];
lnbdz= new double[Nx][Ny][Nz];
//System.out.printf("\n  \n Backward Difference");
//System.out.printf("\n      i\t    j\t    k\t   lnbdx  \t   lnbdy  \t   lnbdz  ");
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++){
//System.out.printf("\n  %5d\t%5d\t%5d",i,j,k);
if (i!=0)
lnbdx[i][j][k]=(Math.log(value[i][j][k])-Math.log(value[i-1][j][k]))/(grid1.x[i]-grid1.x[i-1]); 
else
lnbdx[i][j][k]=0;
if (j!=0)
lnbdy[i][j][k]=(Math.log(value[i][j][k])-Math.log(value[i][j-1][k]))/(grid1.y[j]-grid1.y[j-1]); 
else
lnbdy[i][j][k]=0;
if (k!=0)
lnbdz[i][j][k]=(Math.log(value[i][j][k])-Math.log(value[i][j][k-1]))/(grid1.z[k]-grid1.z[k-1]); 
else
lnbdz[i][j][k]=0;
//System.out.printf("\t%8.4f\t%8.4f\t%8.4f",lnbdx[i][j][k],lnbdy[i][j][k],lnbdz[i][j][k]);
}
}// x method bwddiffcalc

void stepintime(double delt,Variable var1){
int i,j,k;
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++){
if(i!=0 && i!=Nx)
var1.value[i][j][k]=value[i][j][k]+dt[i][j][k]*delt;
else
var1.value[i][j][k]=value[i][j][k];
}
}// method stepintime

void stepends(Variable var1){
int i,j,k;
for(j=0;j<var1.Ny;j++)
for(k=0;k<var1.Nz;k++){
var1.value[0][j][k]=2*var1.value[1][j][k]-var1.value[2][j][k];
var1.value[var1.Nx-1][j][k]=2*var1.value[var1.Nx-2][j][k]-var1.value[var1.Nx-3][j][k];}
}// x method stepintimeends

void correctdt(Variable var1){
int i,j,k;
for(i=0;i<Nx;i++)
for(j=0;j<Ny;j++)
for(k=0;k<Nz;k++)
dt[i][j][k]=0.5*(dt[i][j][k]+var1.dt[i][j][k]);
}//x method changedt

void enforceconditions(){
int i;
for(i=0;i<Nc;i++){
value[conNodes[i][0]][conNodes[i][1]][conNodes[i][2]]=cons[i][conNodes[i][3]];
}
}//x method enforceconditions

}// x class Variable