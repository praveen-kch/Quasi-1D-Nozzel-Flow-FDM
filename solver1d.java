package FDM1D;

// solver1d class
// rachaita Pkc

class solver1d{

//........................Variables..........................
Material mat1;
Pressure pres1;
Grid grid1;
Density dens1;
Temperature temp1;
Velocityx ux1;
Area area1;
setup set1;

//.........................constructor.....................
solver1d(Material mat_1,Grid grid_1,Area area_1,setup set_1, Density dens_1,Temperature temp_1,Velocityx ux_1,Pressure pres_1){
mat1=mat_1;
grid1=grid_1;
area1=area_1;
set1=set_1;
dens1=dens_1;
temp1=temp_1;
ux1=ux_1;
pres1=pres_1;
}// x constructor

//........................methods...........................
double getdelt(){
double a,delx;
double[] dt=new double[grid1.Nx];
double delt=1000;
int i;
for(i=0;i<grid1.Nx;i++){
if (i==0)
{delx=grid1.x[1]-grid1.x[0];} 
else if(i==grid1.Nx-1)
{delx=grid1.x[i]-grid1.x[i-1];}
else
{delx=(grid1.x[i+1]-grid1.x[i-1])/2;}
a=Math.sqrt(Math.abs(temp1.value[i][0][0]));
dt[i]=set1.courantNum*(delx/(a+ux1.value[i][0][0]));
delt=Math.abs(Math.min(delt,dt[i]));
}
return delt;
}// x method getdelt

void run(Varstore[] store){
int[] Ns=new int[3];
Ns[0]=grid1.Nx;
Ns[1]=grid1.Ny;
Ns[2]=grid1.Nz;
Density dens2=new Density(Ns);
Temperature temp2=new Temperature(Ns);
Velocityx ux2=new Velocityx(Ns);

area1.lnfwddiffcalc(grid1);
area1.lnbwddiffcalc(grid1);

while (set1.step<set1.maxSteps){
set1.step++;
set1.delt=getdelt();
set1.t_line[set1.step]=set1.t_line[set1.step-1]+set1.delt;
//System.out.printf("\n  step=%5d\tdelt=%8.4f\tdelt=%8.4f",set1.step,set1.delt,set1.t_line[set1.step]);

// Initial Predictor steps
dens1.fwddiffcalc(grid1);
ux1.fwddiffcalc(grid1);
temp1.fwddiffcalc(grid1);
dens1.dodtf(ux1,area1);
ux1.dodtf(dens1,temp1,mat1,area1);
temp1.dodtf(ux1,mat1,area1);
dens1.stepintime(set1.delt,dens2);
temp1.stepintime(set1.delt,temp2);
ux1.stepintime(set1.delt,ux2);
//dens2.printDensity();
//temp2.printTemperature();
//ux2.printVelocityx();
// Corrector steps
dens2.bwddiffcalc(grid1);
ux2.bwddiffcalc(grid1);
temp2.bwddiffcalc(grid1);
dens2.dodtb(ux2,area1);
ux2.dodtb(dens2,temp2,mat1,area1);
temp2.dodtb(ux2,mat1,area1);

// correcting the time rates of change
dens1.correctdt(dens2);
temp1.correctdt(temp2);
ux1.correctdt(ux2);

// Corrected prediction
dens1.stepintime(set1.delt,dens1);
temp1.stepintime(set1.delt,temp1);
ux1.stepintime(set1.delt,ux1);
dens1.stepends(dens1);
temp1.stepends(temp1);
ux1.stepends(ux1);
dens1.enforceconditions();
temp1.enforceconditions();

store[0].update(dens1,set1.t_line[set1.step]);
store[1].update(ux1,set1.t_line[set1.step]);
store[2].update(temp1,set1.t_line[set1.step]);

}// ends while
//Printing the results
//dens1.printDensity();
//temp1.printTemperature();
//ux1.printVelocityx();

}// x method run

}// x class solver1d