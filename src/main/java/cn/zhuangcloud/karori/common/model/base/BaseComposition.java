package cn.zhuangcloud.karori.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseComposition<M extends BaseComposition<M>> extends Model<M> implements IBean {

	public void setCid(java.lang.Integer cid) {
		set("cid", cid);
	}
	
	public java.lang.Integer getCid() {
		return getInt("cid");
	}

	/**
	 * kcal
	 */
	public void setCalorie(java.lang.Double calorie) {
		set("calorie", calorie);
	}
	
	/**
	 * kcal
	 */
	public java.lang.Double getCalorie() {
		return getDouble("calorie");
	}

	/**
	 * g
	 */
	public void setProtein(java.lang.Double protein) {
		set("protein", protein);
	}
	
	/**
	 * g
	 */
	public java.lang.Double getProtein() {
		return getDouble("protein");
	}

	/**
	 * g
	 */
	public void setFat(java.lang.Double fat) {
		set("fat", fat);
	}
	
	/**
	 * g
	 */
	public java.lang.Double getFat() {
		return getDouble("fat");
	}

	/**
	 * g
	 */
	public void setCarbohydrate(java.lang.Double carbohydrate) {
		set("carbohydrate", carbohydrate);
	}
	
	/**
	 * g
	 */
	public java.lang.Double getCarbohydrate() {
		return getDouble("carbohydrate");
	}

	/**
	 * mg
	 */
	public void setSodium(java.lang.Double sodium) {
		set("sodium", sodium);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getSodium() {
		return getDouble("sodium");
	}

	/**
	 * g
	 */
	public void setSalt(java.lang.Double salt) {
		set("salt", salt);
	}
	
	/**
	 * g
	 */
	public java.lang.Double getSalt() {
		return getDouble("salt");
	}

	/**
	 * mg
	 */
	public void setCholesterol(java.lang.Double cholesterol) {
		set("cholesterol", cholesterol);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getCholesterol() {
		return getDouble("cholesterol");
	}

	/**
	 * g
	 */
	public void setSugar(java.lang.Double sugar) {
		set("sugar", sugar);
	}
	
	/**
	 * g
	 */
	public java.lang.Double getSugar() {
		return getDouble("sugar");
	}

	/**
	 * ug
	 */
	public void setVitaminA(java.lang.Double vitaminA) {
		set("vitaminA", vitaminA);
	}
	
	/**
	 * ug
	 */
	public java.lang.Double getVitaminA() {
		return getDouble("vitaminA");
	}

	/**
	 * ug
	 */
	public void setVitaminD(java.lang.Double vitaminD) {
		set("vitaminD", vitaminD);
	}
	
	/**
	 * ug
	 */
	public java.lang.Double getVitaminD() {
		return getDouble("vitaminD");
	}

	/**
	 * mg
	 */
	public void setVitaminE(java.lang.Double vitaminE) {
		set("vitaminE", vitaminE);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getVitaminE() {
		return getDouble("vitaminE");
	}

	/**
	 * ug
	 */
	public void setVitaminK(java.lang.Double vitaminK) {
		set("vitaminK", vitaminK);
	}
	
	/**
	 * ug
	 */
	public java.lang.Double getVitaminK() {
		return getDouble("vitaminK");
	}

	/**
	 * mg
	 */
	public void setVitaminB1(java.lang.Double vitaminB1) {
		set("vitaminB1", vitaminB1);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getVitaminB1() {
		return getDouble("vitaminB1");
	}

	/**
	 * mg
	 */
	public void setVitaminB2(java.lang.Double vitaminB2) {
		set("vitaminB2", vitaminB2);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getVitaminB2() {
		return getDouble("vitaminB2");
	}

	/**
	 * mg
	 */
	public void setVitaminB6(java.lang.Double vitaminB6) {
		set("vitaminB6", vitaminB6);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getVitaminB6() {
		return getDouble("vitaminB6");
	}

	/**
	 * ug
	 */
	public void setVitaminB12(java.lang.Double vitaminB12) {
		set("vitaminB12", vitaminB12);
	}
	
	/**
	 * ug
	 */
	public java.lang.Double getVitaminB12() {
		return getDouble("vitaminB12");
	}

	/**
	 * mg
	 */
	public void setVitaminC(java.lang.Double vitaminC) {
		set("vitaminC", vitaminC);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getVitaminC() {
		return getDouble("vitaminC");
	}

	/**
	 * mg
	 */
	public void setCalcium(java.lang.Double calcium) {
		set("calcium", calcium);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getCalcium() {
		return getDouble("calcium");
	}

	/**
	 * mg
	 */
	public void setIron(java.lang.Double iron) {
		set("iron", iron);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getIron() {
		return getDouble("iron");
	}

	/**
	 * mg
	 */
	public void setMagnesium(java.lang.Double magnesium) {
		set("magnesium", magnesium);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getMagnesium() {
		return getDouble("magnesium");
	}

	/**
	 * mg
	 */
	public void setZinc(java.lang.Double zinc) {
		set("zinc", zinc);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getZinc() {
		return getDouble("zinc");
	}

	/**
	 * mg
	 */
	public void setPotassium(java.lang.Double potassium) {
		set("potassium", potassium);
	}
	
	/**
	 * mg
	 */
	public java.lang.Double getPotassium() {
		return getDouble("potassium");
	}

}
