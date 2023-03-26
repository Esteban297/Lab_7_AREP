# Laboratorio 7 AREP
En este laboratorio, se desarrolló una aplicación Web segura utilizando Spark

### 1. Para empezar, creamos un par de llaves públicas y privadas con sus certificado y las almacenamos  todo en un archivo protegido

  Usamos los siguientes comandos:
  
  ```
  keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650
  ```
  
  Importamos el certificado con el siguiente comando:
  
  ```
  keytool -export -keystore ./ecikeystore.p12 -alias ecikeypair -file ecicert.cer
  ```
  
  Importamos el certificado a un TrustStore:
  
  ```
  keytool -import -file ./ecicert.cer -alias firstCA -keystore myTrustStore
  ```
  
### 2. Implementamos el secureURL y los dos servidores
  
  ![image](https://user-images.githubusercontent.com/90571387/227788430-9e4cf3cf-2bbb-4877-b307-2c196dee6705.png)

### 3. Creamos las dos instancias en AWS 

   ![image](https://user-images.githubusercontent.com/90571387/227788620-0684db6f-089d-45a4-b8f3-532654872e2a.png)

### 4. Creamos las reglas de entrada en cada instancia para abrir el trafico

  ![image](https://user-images.githubusercontent.com/90571387/227788686-7326dd18-3f92-418a-85a1-6e76e010c678.png)

### 5. Instalamos java en las maquinas

  ```
  sudo yum install java-17-amazon-corretto-devel
  ```
  
  ![image](https://user-images.githubusercontent.com/90571387/227788825-8cf350dd-9843-4ec2-a4ec-878409448414.png)

### 6. Agregamos el archivo target en cada maquina y ejecutamos un servidor en cada una de ellas.
  ![image](https://user-images.githubusercontent.com/90571387/227788882-4aeeacda-75a7-4f5a-95f0-0cd0f1d42488.png)

### 7. Probamos que funcione 
   
   * Maquina 1 local
   
   ![image](https://user-images.githubusercontent.com/90571387/227788976-4e067fa2-b17f-4715-b9f5-a45404e4f462.png)

   * Maquina 1 remota 
   
   ![image](https://user-images.githubusercontent.com/90571387/227789057-61fadd58-bc8d-4d66-95c5-d2bb55166faf.png)
   
   * Maquina 2 local
   
   ![image](https://user-images.githubusercontent.com/90571387/227789161-b18c023d-65a2-489d-84e1-d7d902113fd3.png)
   
   * Maquina 2 remota
   
   ![image](https://user-images.githubusercontent.com/90571387/227789125-4b265b7d-5eb7-4e76-99b5-41c1df8fd25d.png)


### 8. Video demostración

   * https://www.youtube.com/watch?v=LKBaOVUXUcU

   

  
  
  
  
