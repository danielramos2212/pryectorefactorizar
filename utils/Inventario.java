package utils;
public class Inventario {
    public double calcularTotalInventario(int nP, double pU,
                                          int mC, int dV, int s, String tC) {
// Cálculo del valor base del inventario
        double vB = nP * pU;
// Descuento por antigüedad (si lleva más de 12 meses
// en catálogo)
        double descAnt = 0;
        if (mC > 12) {
            descAnt = vB * 0.15;
        }
// Penalización por baja rotación (más de 60 días sin vender)
        double penalRot = 0;
        if (dV > 60) {
            penalRot = vB * 0.10;
        }
// Bonificación por stock alto (más de 100 unidades)
        double bonifStock = 0;
        if (s > 100) {
            bonifStock = vB * 0.05;
        }
// Ajuste por tipo de categoría
        double ajusteCat = 0;
        if (tC.equals("premium")) {
            ajusteCat = vB * 0.20;
        } else if (tC.equals("basica")) {
            ajusteCat = -vB * 0.05;
        }
// Cálculo final
        return vB - descAnt - penalRot + bonifStock + ajusteCat;
    }
}
