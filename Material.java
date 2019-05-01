package FDM1D;

// class Material
// rachaitha :pkc

class Material{

//...................Variables...............

double gamma=1.4, R=287.058;

//...................constructor.............

Material(double gamma_, double R_){
gamma=gamma_;
R=R_;
}// x constructor

//...................Methods..................

void printMaterial(){
System.out.printf("\n  Material Properties");
System.out.printf("\n  Gamma= %+-8.4f \t R = %+-8.4f\n",gamma,R);
}// x Method printMaterial

}// x class Material