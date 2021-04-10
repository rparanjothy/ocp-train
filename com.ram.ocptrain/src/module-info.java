module com.ram.ocptrain {
//    exports com.ram.ocptrain.pkg1 to com.ram.ocptrain.app;
    opens com.ram.ocptrain.pkg1 to com.ram.ocptrain.app;
    exports com.ram.ocptrain.pkg1;
}