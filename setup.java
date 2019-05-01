package FDM1D;

// setup class
// rachaitha : Pkc

class setup{
double courantNum, maxTime;
double t, delt;
int maxSteps, step;
double[] t_line;

//............................constructor.......................
setup(int maxSteps_,double maxTime_,double courantNum_){
maxSteps=maxSteps_;
maxTime=maxTime_;
courantNum=courantNum_;
t=0;
t_line=new double[maxSteps+1];
t_line[0]=t;
delt=0;
step=0;
}

}