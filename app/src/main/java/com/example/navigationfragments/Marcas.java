package com.example.navigationfragments;

import java.util.ArrayList;
import java.util.List;

public class Marcas {
    /*public static final String[] XIAOMI = {"Redmi Note 7", "Redmi Note 7 Pro", "Redmi Note 8", "Redmi Note 8 Pro",
            "Mi A2", "Mi A2 Lite"};

    public static final String[] SAMSUNG = {"Galaxy S8", "Galaxy S9", "Galaxy S10", "Galaxy S20"};

    public static final String[] APPLE = {};

    public static final String[] HUAWEI = {};

    public static final String[] NOKIA = {};*/

    public static List<Telefono> Xiaomi(){
        List<Telefono> lista = new ArrayList<>();
        lista.add(new Telefono("Redmi Note 7", "Xiaomi", R.drawable.note7, "500$", "El Xiaomi Redmi Note 7 es el nuevo miembro de la serie Redmi Note, esta vez con una impresionante cámara dual de 48 MP + 5 MP. Potenciado por un procesador Qualcomm Snapdragon 660 de ocho núcleos, el Redmi Note 7 está disponible con 3GB de RAM y 32GB de almacenamiento o bien 4GB o 6GB de RAM con 64GB de almacenamiento, con una pantalla Full HD+ de 6.3 pulgadas con notch en forma de gota de agua. Con una batería de 4000 mAh con carga rápida, el Redmi Note 7 completa sus características con un lector de huellas posterior, infrarrojo, puerto USB-C, cámara frontal de 13 MP y MIUI 10 basado en Android 9.0 Pie."));
        lista.add(new Telefono("Redmi Note 7 Pro", "Xiaomi", R.drawable.note7pro, "600$", "El Xiaomi Redmi Note 7 Pro es una variante avanzada del Redmi Note 7, con una pantalla Full HD+ de 6.3 pulgadas. Potenciado por un procesador Snapdragon 675, el Redmi Note 7 Pro cuenta con opciones de 6GB de memoria RAM y 128GB de almacenamiento, o 4GB de memoria RAM y 64GB de almacenamiento, en ambos casos expandible vía microSD. La cámara principal del Redmi Note 7 Pro es dual, de 48 MP + 5 MP, y la cámara frontal es de 13 MP. El Redmi Note 7 Pro completa sus características con lector de huellas en su anverso, puerto USB-C, y batería de 4000 mAh con soporte de carga rápida Quick Charge 4."));
        lista.add(new Telefono("Redmi Note 8", "Xiaomi", R.drawable.note8, "700$", "El Xiaomi Redmi Note 8 marca la octava generación de la serie Redmi Note, esta vez con una pantalla Full HD+ de 6.3 pulgadas y potenciado por un procesador Snapdragon 665 de ocho núcleos. Con opciones de 4GB de memoria RAM y 64GB de almacenamiento, 6GB de RAM y 64GB de almacenamiento o 6GB de RAM y 128GB de almacenamiento, el Redmi Note 8 cuenta con una cámara cuádruple en su posterior de 48 MP + 8 MP + 2 MP + 2 MP, y su cámara para selfies es de 13 megapixels. El Redmi Note 8 completa sus características con una batería de 4000 mAh con soporte para carga rápida, lector de huellas montado en su parte posterior, resistencia a salpicaduras y corre MIUI 10 basado en Android 9.0 Pie."));
        lista.add(new Telefono("Redmi Note 8 Pro", "Xiaomi", R.drawable.note8pro, "800$", "El Xiaomi Redmi Note 8 Pro es el smartphone más poderoso de la octava serie Redmi Note. El Redmi Note 8 Pro cuenta con una pantalla Full HD+ de 6.53 pulgadas, y está potenciado por un procesador Mediatek Helio G90T de ocho núcleos con variantes de 6GB de memoria RAM y 64GB de espacio de almacenamiento, o 8GB de memoria RAM con 64GB o 128GB de almacenamiento interno. La cámara posterior del Redmi Note 8 Pro es cuádruple, de 64 MP + 8 MP + 2 MP + 2 MP, mientras que su cámara selfie es de 20 MP. El Redmi Note 8 Pro completa sus características con protección Gorilla Glass 5 y certificación IP52 a prueba de agua, puerto USB-C, NFC, batería de 4500 mAh con carga rápida, sistema de enfriamiento líquido para mantener la temperatura del procesador controlada y corre MIUI 10 basado en Android 9 Pie."));
        return lista;
    }
    public static List<Telefono> Apple(){
        List<Telefono> lista = new ArrayList<>();
        lista.add(new Telefono("Iphone 5", "Apple", R.drawable.iphone5, "400$", "El Apple iPhone 5 es la sexta generación del iPhone, esta vez con una pantalla más grande de 4 pulgadas, aumentando su tamaño a lo alto. Además posee un perfil de tan sólo 7.6 mm siendo uno de los smartphones más delgados del mercado. El iPhone 5 posee un procesador A6 que promete el doble de performance que su predecesor en el iPhone 4S. También es el primer iPhone con soporte LTE global."));
        lista.add(new Telefono("Iphone 6", "Apple", R.drawable.iphone6, "600$", "El Apple iPhone 6 sube la apuesta de Apple con una pantalla de mayor tamaño de 4.7 pulgadas protegida por un cristal ultra resistente, nuevo procesador A8, 16GB, 64GB o 128GB de almacenamiento interno, cámara trasera de 8 megapixels con flash, cámara frontal de 1.2MP, conectividad 4G LTE y iOS 8."));
        lista.add(new Telefono("Iphone 7", "Apple", R.drawable.iphone7, "800$", "El Apple iPhone 7 es el sucesor del iPhone 6s del año pasado. Aunque conserva mucho de su diseño exterior, el iPhone 7 cuenta con mejoras en sus características, incluyendo su nuevo chip A10 Fusion, un 40 por ciento más rápido que el anterior A9. Su botón de inicio ahora es sensible al tacto, y cuenta con parlantes stereo. El iPhone 7 además elimina el conector de auriculares de 3.5mm, es resistente al agua, y mejora su cámara de 12 MP notablemente."));
        return lista;
    }

}
