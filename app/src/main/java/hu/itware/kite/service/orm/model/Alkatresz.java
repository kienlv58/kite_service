package hu.itware.kite.service.orm.model;

import java.util.Date;

import hu.itware.kite.service.orm.model.annotations.Key;

/**
 * Created by szeibert on 2015.09.14..
 */
public class Alkatresz extends BaseDatabaseObject {

	@Key
	public String munkalapkod;

	@Key
	public String tempkod;

	@Key
	public String alkatreszkod;

	@Key
    public String cikkszam;

	public String cikknev;

    public String rendszer;

	public Double mozgomennyiseg;

	public String mennyisegiegyseg;

	public String sorszam;

	public String agazatiszam;

	public Date rogzitesdatum;

	@Key
	public String bizonylatszam;

	public String munkalapsorszam;

	@Key
    public String mozgasazonosito;


    public Alkatresz() {
    }

    public Alkatresz(String cikknev, String rendszer, String cikkszam) {
        this.cikknev = cikknev;
        this.rendszer = rendszer;
        this.cikkszam = cikkszam;
    }

    @Override
    public String toString() {
        return "Alkatresz{" +
                "cikkszam='" + cikkszam + '\'' +
                ", rendszer='" + rendszer + '\'' +
                ", cikknev='" + cikknev + '\'' +
                '}';
    }
}
