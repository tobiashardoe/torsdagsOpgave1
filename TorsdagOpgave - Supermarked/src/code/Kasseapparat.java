package code;

import java.util.*;

public class Kasseapparat {

    private Map<String, Vare> tilbudsMap;

    public Kasseapparat(Collection<Vare> tilbudsVarer) {
        tilbudsMap = new HashMap<>();
        for (Vare v : tilbudsVarer) {
            tilbudsMap.put(v.getId(), v);
        }
    }

    public void udskrivBon(Collection<Vare> kurv) {

        Map<Vare, Integer> samledeVarer = new LinkedHashMap<>();
        for (Vare v : kurv) {
            samledeVarer.put(v, samledeVarer.getOrDefault(v, 0) + 1);
        }

        double total = 0.0;
        StringBuilder bon = new StringBuilder();

        bon.append("===== KVITTERING =====\n");

        for (Vare vare : samledeVarer.keySet()) {
            int antal = samledeVarer.get(vare);
            double normalPris = vare.getPrice();

            Vare tilbud = tilbudsMap.get(vare.getId());
            double pris = (tilbud != null) ? tilbud.getPrice() : normalPris;

            bon.append(vare.getName()).append("\n");
            bon.append(antal + " x " + pris + " = " + String.format("%.2f", antal * pris)).append(" kr\n");

            if (tilbud != null) {
                double rabat = (normalPris - pris) * antal;
                bon.append("  RABAT: -" + String.format("%.2f", rabat) + " kr\n");
            }

            bon.append("\n");

            total += antal * pris;
        }

        double moms = total * 0.20;

        bon.append("---------------------\n");
        bon.append("MOMS (20%): " + String.format("%.2f", moms) + " kr\n");
        bon.append("TOTAL:     " + String.format("%.2f", total) + " kr\n");

        System.out.println(bon);
    }
}
