import inspect
from typing import Type, Dict, Any, get_type_hints

# bien toan cuc -> luu tru ong nao la dependence
__injectable_class : Dict[Type, type] = {}

# dang ky cac dependency vao container de container quan ly
def autowired(cls):
    __injectable_class[cls] = cls
    return cls

# demo container
class IocContainer():
    def __init__(self):
        '''
        support singleton -> attribute singleton
        '''
        self._singleton_instances : Dict[Type : any] = {}
    
    '''
    init dependency for container and user in program
    '''
    def create_dependency(self, cls : Type):
        pass