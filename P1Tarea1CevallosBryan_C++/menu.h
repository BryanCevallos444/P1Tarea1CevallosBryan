#ifndef MENU_H_INCLUDED
#define MENU_H_INCLUDED

#include <iostream>
#include <fstream>

using namespace std;

void Menu ();
void Datos();
void Promedio();

float Notas1,Notas2,Notas3,result;




void Menu (){

int opc;
cout<<"=======MENU========="<<endl;
cout<<"1.INGRESO DE LAS NOTAS "<<endl;
cout<<"2. TXT RESULTADO DE (PROMEDIOS)"<<endl;
cout<<"3. SALIR "<<endl;
cout<<"INGRESE SU OPCION : "<<endl;
cin>>opc;
switch(opc){
case 1:
     Datos();
 Menu();
    break;
case 2:
     Promedio();
Menu();
    break;
case 3:
 cout<<"gracias por usar el programa"<<endl;
     break;
default :
     cout<<" el dato ingresado es incorrecto ingrese nuevamente"<<endl;
     Menu();

}
}

void Datos(){

do{
cout<<"ingrese el primer promedio (0 a 20)"<<endl;
cin>>Notas1;
}
while(Notas1<0||Notas1>20);

do{
cout<<"ingrese el segundo promedio (0 a 20)"<<endl;
cin>>Notas2;
}
while(Notas2<0||Notas2>20);
    do{
cout<<"ingrese el tercer promedio (0 a 20)"<<endl;
cin>>Notas3;
}
while(Notas3<0||Notas3>20);

ofstream archivo("Cevallos_Promedio.txt");
if(archivo.is_open()){
archivo<< "Notas registradas: "<<endl;
archivo<< "NOTAS 1:  " << Notas1<<endl;
archivo<< "NOTAS 2:  " << Notas2<<endl;
archivo<< "NOTAS 3:  " << Notas3<<endl;
archivo.close();
cout<<"Notas registradas en el archivo Cevallos_Promedio.txt"<<endl;
} else {
cout<<"Error al abrir el archivo para guardar los promedios"<<endl;
}
}



void Promedio(){

result=(Notas1+Notas2+Notas3)/3;

ofstream archivo("Cevallos_Promedio.txt", ios::app);
if(archivo.is_open()){
   archivo << "Promedio: " << result << endl;
    if(result>=14){
    archivo<<"aprobado"<<endl;
}else{
 archivo<<"reprobado"<<endl;
}
        archivo.close();
        cout<<"Promedio agregado al archivo Cevallos_Promedio.txt"<<endl;
    } else {
        cout<<"Error al abrir el archivo para guardar el promedio."<<endl;
    }

}





#endif // MENU_H_INCLUDED
