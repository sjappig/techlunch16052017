Vincit Vallila Techlunch 16.5.2017
==================================

CORBA live coding for minimal server-client example with idl using name service

  * Server: Ubuntu/Java/Jacorb

  * Client: Windows/C++/Omniorb


Ubuntu details
--------------

```idlj -falltie -td src/main/java -pkgTranslate Vallila fi.vincit.vallila.corba.generated vallilaservice.idl```

```PATH=$PATH:/home/jaripekkary/jacorb-3.8/bin ns -DOAPort=1337```

```PATH=$PATH:/home/jaripekkary/jacorb-3.8/bin jaco -DORBInitRef.NameService=corbaloc::localhost:1337/NameService fi.vincit.vallila.corba.VallilaServer```


Windows details
---------------

```omniidl -bcxx vallilaservice.idl```

Required libs `ws2_32.lib omniORB4.lib omnithread.lib omniDynamic4.lib`

Args for client `-ORBInitRef NameService=corbaloc::10.175.20.80:1337/NameService`

