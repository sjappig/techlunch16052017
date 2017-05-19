#include "vallilaservice.hh"
#include <iostream>

int main(int argc, char** argv)
{
	CORBA::ORB_ptr orb = CORBA::ORB_init(argc, argv);

	CORBA::Object_ptr corbaObj = orb->resolve_initial_references("NameService");

	CosNaming::Name name;
	name.length(1);
	name[0].id = "VallilaService";

	corbaObj = CosNaming::NamingContext::_narrow(corbaObj)->resolve(name);

	Vallila::VallilaService::_ptr_type vallilaService = Vallila::VallilaService::_narrow(corbaObj);

	Vallila::Data* data;

	data = vallilaService->getData();

	std::cout << data->best8BallPlayer << ", " << data->beers << std::endl;

	int beers = 0;

	std::cout << ">";
	std::cin >> beers;

	vallilaService->setBeers(beers);

	data = vallilaService->getData();

	std::cout << data->best8BallPlayer << ", " << data->beers << std::endl;

	orb->destroy();

	return 0;
}
