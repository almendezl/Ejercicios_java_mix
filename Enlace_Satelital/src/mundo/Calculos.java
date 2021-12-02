package mundo;

public class Calculos {

	/*
	 *----------------SUBSISTEMA DE ANTENAS--------------- 
	 */
	private double frecuencia_Ghz;
	private double diametro_antena;
	private double ganancia_max_antena;
	private double eficiencia_antena;
	private double alfa_antena;
	private double area_antena;
	private double lambda;
	private double tetha_3db;
	
	
	
	/*
	 * --------------------CONSTANTES-------------------
	 */
	private double cte_keppler = 3.986*10E5;
	private double radio_Tierra = 6378; // en Km
	private double vel_luz_C = 3*10E8;
	private double PI = Math.PI;
	private double h_GEO = 42164;//Km
	private double req = 8500; //radio con curvatura de la tierra en km
	
	
	/*
	 * --------------BANDAS DE FRECUENCIAS---------------
	 */
	
	private double banda_C [] = {6, 4}; // primero la frec de subida en Ghz 
	private double banda_X [] = {8, 7};
	private double banda_Ku [] = {14, 12};
	private double banda_Ka [] = {30, 20};
	private double banda_QV [] = {50, 40};
	
	
	/*
	 * ---------APUNTAMIENTO DE ANTENAS---------------------
	 */
	private double angulo_elevacion; //tetha
	private double angulo_azimud;
	private double latitud_ET; //en grados
	private double longitud_sat; //en grados
	private double delthaL;
	private double C; //para formula no es la vel de luz
	private double tetha_prima;
	private double azimud_prima; //revisar los casos
	private double rango_S;
	
	/*
	 * -----------LAA-ATENUACION POR ABSORCION ATMOSFERICA--------
	 */
	private double Lcenit [][] = {{4, 0.0371}, {6, 0.0408}, {12, 0.0636}, {14, 0.0791}, {20, 0.2694}, {30, 0.2498}};
	private double Laa;
	
	/*
	 * ----ATENUACION POR LLUVIA--------------------
	 */
	
	private double hr;
	private double ho; //altitud de ET sobre el nivel del mar en km
	private double d;
	private double r_001;
	private double R_001; //sacar de la imagen o libro
	private double coef_de_atenuacion;
	private double disponibilidad;
	private double L_lluvia;
	
	
	/*
	 * --------PERDIDAS EN EL ESPACIO LIBRE-------------
	 */
	private double Lel;
	
	/*
	 * -----------PERDIDA POR DESAPUNTAMIENTO--------------
	 */
	private double Ld_tx;
	private double alfa_tx;
	private double tetha_3db_tx;
	
	private double Ld_rx;
	private double alfa_rx;
	private double tetha_3db_rx;
	
	/*
	 * -----------PERDIDA DE LINEA Y CONECTORES-------------------
	 */
	private double Lc;
	
	/*
	 * ------------POTENCIA DE RUIDO-------------------
	 */
	
	/*
	 * -------------FACTOR DE CALIDAD-------------------------
	 */
	
	/*
	 * --------------VARIABLES DE RESULTADOS DE LOS ENLACES---------------
	 */
	private double L_propagacion;
	private double PIRE_ET;
	
	
	
	public Calculos() {
		
	}
	
	public void ganancia_watts() {
		
	}
	public void ganancia_dbi() {
		
	}
	
	public void minutos_a_grados() {
		
	}
	public void rango_s() {
	
	}
	public void laa() {
		
	}

	

	/*
	 * -------------GET Y SET---------------
	 */
	
	public double getFrecuencia_Ghz() {
		return frecuencia_Ghz;
	}

	public void setFrecuencia_Ghz(double frecuencia_Ghz) {
		this.frecuencia_Ghz = frecuencia_Ghz;
	}

	public double getDiametro_antena() {
		return diametro_antena;
	}

	public void setDiametro_antena(double diametro_antena) {
		this.diametro_antena = diametro_antena;
	}

	public double getGanancia_max_antena() {
		return ganancia_max_antena;
	}

	public void setGanancia_max_antena(double ganancia_max_antena) {
		this.ganancia_max_antena = ganancia_max_antena;
	}

	public double getEficiencia_antena() {
		return eficiencia_antena;
	}

	public void setEficiencia_antena(double eficiencia_antena) {
		this.eficiencia_antena = eficiencia_antena;
	}

	public double getAlfa_antena() {
		return alfa_antena;
	}

	public void setAlfa_antena(double alfa_antena) {
		this.alfa_antena = alfa_antena;
	}

	public double getArea_antena() {
		return area_antena;
	}

	public void setArea_antena(double area_antena) {
		this.area_antena = area_antena;
	}

	public double getLambda() {
		return lambda;
	}

	public void setLambda(double lambda) {
		this.lambda = lambda;
	}

	public double getTetha_3db() {
		return tetha_3db;
	}

	public void setTetha_3db(double tetha_3db) {
		this.tetha_3db = tetha_3db;
	}

	public double getCte_keppler() {
		return cte_keppler;
	}

	public void setCte_keppler(double cte_keppler) {
		this.cte_keppler = cte_keppler;
	}

	public double getRadio_Tierra() {
		return radio_Tierra;
	}

	public void setRadio_Tierra(double radio_Tierra) {
		this.radio_Tierra = radio_Tierra;
	}

	public double getVel_luz_C() {
		return vel_luz_C;
	}

	public void setVel_luz_C(double vel_luz_C) {
		this.vel_luz_C = vel_luz_C;
	}

	public double getPI() {
		return PI;
	}

	public void setPI(double pI) {
		PI = pI;
	}

	public double getH_GEO() {
		return h_GEO;
	}

	public void setH_GEO(double h_GEO) {
		this.h_GEO = h_GEO;
	}

	public double getReq() {
		return req;
	}

	public void setReq(double req) {
		this.req = req;
	}

	public double[] getBanda_C() {
		return banda_C;
	}

	public void setBanda_C(double[] banda_C) {
		this.banda_C = banda_C;
	}

	public double[] getBanda_X() {
		return banda_X;
	}

	public void setBanda_X(double[] banda_X) {
		this.banda_X = banda_X;
	}

	public double[] getBanda_Ku() {
		return banda_Ku;
	}

	public void setBanda_Ku(double[] banda_Ku) {
		this.banda_Ku = banda_Ku;
	}

	public double[] getBanda_Ka() {
		return banda_Ka;
	}

	public void setBanda_Ka(double[] banda_Ka) {
		this.banda_Ka = banda_Ka;
	}

	public double[] getBanda_QV() {
		return banda_QV;
	}

	public void setBanda_QV(double[] banda_QV) {
		this.banda_QV = banda_QV;
	}

	public double getAngulo_elevacion() {
		return angulo_elevacion;
	}

	public void setAngulo_elevacion(double angulo_elevacion) {
		this.angulo_elevacion = angulo_elevacion;
	}

	public double getAngulo_azimud() {
		return angulo_azimud;
	}

	public void setAngulo_azimud(double angulo_azimud) {
		this.angulo_azimud = angulo_azimud;
	}



	public double getLatitud_ET() {
		return latitud_ET;
	}

	public void setLatitud_ET(double latitud_ET) {
		this.latitud_ET = latitud_ET;
	}

	public double getLongitud_sat() {
		return longitud_sat;
	}

	public void setLongitud_sat(double longitud_sat) {
		this.longitud_sat = longitud_sat;
	}

	public double getDelthaL() {
		return delthaL;
	}

	public void setDelthaL(double delthaL) {
		this.delthaL = delthaL;
	}

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public double getTetha_prima() {
		return tetha_prima;
	}

	public void setTetha_prima(double tetha_prima) {
		this.tetha_prima = tetha_prima;
	}

	public double getAzimud_prima() {
		return azimud_prima;
	}

	public void setAzimud_prima(double azimud_prima) {
		this.azimud_prima = azimud_prima;
	}

	public double getRango_S() {
		return rango_S;
	}

	public void setRango_S(double rango_S) {
		this.rango_S = rango_S;
	}

	public double[][] getLcenit() {
		return Lcenit;
	}

	public void setLcenit(double[][] lcenit) {
		Lcenit = lcenit;
	}

	public double getLaa() {
		return Laa;
	}

	public void setLaa(double laa) {
		Laa = laa;
	}

	public double getHr() {
		return hr;
	}

	public void setHr(double hr) {
		this.hr = hr;
	}

	public double getHo() {
		return ho;
	}

	public void setHo(double ho) {
		this.ho = ho;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getr_001() {
		return r_001;
	}

	public void setr_001(double r_001) {
		this.r_001 = r_001;
	}

	public double getR_001() {
		return R_001;
	}

	public void setR_001(double r_001) {
		this.R_001 = r_001;
	}

	public double getCoef_de_atenuacion() {
		return coef_de_atenuacion;
	}

	public void setCoef_de_atenuacion(double coef_de_atenuacion) {
		this.coef_de_atenuacion = coef_de_atenuacion;
	}

	public double getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(double disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public double getL_lluvia() {
		return L_lluvia;
	}

	public void setL_lluvia(double l_lluvia) {
		L_lluvia = l_lluvia;
	}

	public double getLel() {
		return Lel;
	}

	public void setLel(double lel) {
		Lel = lel;
	}

	public double getLd_tx() {
		return Ld_tx;
	}

	public void setLd_tx(double ld_tx) {
		Ld_tx = ld_tx;
	}

	public double getAlfa_tx() {
		return alfa_tx;
	}

	public void setAlfa_tx(double alfa_tx) {
		this.alfa_tx = alfa_tx;
	}

	public double getTetha_3db_tx() {
		return tetha_3db_tx;
	}

	public void setTetha_3db_tx(double tetha_3db_tx) {
		this.tetha_3db_tx = tetha_3db_tx;
	}

	public double getLd_rx() {
		return Ld_rx;
	}

	public void setLd_rx(double ld_rx) {
		Ld_rx = ld_rx;
	}

	public double getAlfa_rx() {
		return alfa_rx;
	}

	public void setAlfa_rx(double alfa_rx) {
		this.alfa_rx = alfa_rx;
	}

	public double getTetha_3db_rx() {
		return tetha_3db_rx;
	}

	public void setTetha_3db_rx(double tetha_3db_rx) {
		this.tetha_3db_rx = tetha_3db_rx;
	}

	public double getLc() {
		return Lc;
	}

	public void setLc(double lc) {
		Lc = lc;
	}

	public double getL_propagacion() {
		return L_propagacion;
	}

	public void setL_propagacion(double l_propagacion) {
		L_propagacion = l_propagacion;
	}

	public double getPIRE_ET() {
		return PIRE_ET;
	}

	public void setPIRE_ET(double pIRE_ET) {
		PIRE_ET = pIRE_ET;
	}
	
	
	
	
}
