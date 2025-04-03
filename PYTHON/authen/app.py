import time
import threading
from datetime import datetime
import multiprocessing



class user():
    #name, role
    def __init__(self, name, role):
        self.name = name
        self.role = role

def require_permission(role_name):
    def decorator(func):
        def wrapper(user):
            #implement bizz check role here
            #role : if user have role = have (declare in decorator) -> return func
            if (user.role == role_name):
                return func(user)
            else:
                print(f'{user.name} do not have permission!')
                return
        return wrapper
    return decorator

def decorator2(func):
    def wrapper(user):
            #implement bizz check role here
            #role : if user have role = have (declare in decorator) -> return func
        if (user.role == 'admin'):
            return func(user)
        else:
            print(f'{user.name} do not have permission!')
            return
        return wrapper
    return decorator2
#return decorator



# truyen 1 list check ton tai 1 trong cac role -> pass
# @require_permission(role_name = 'guest')
# def demo_func_require_admin_role(user):
#     print(f"GOOD JOB {user.name}...!")

# u1 = user('chien', 'admin')
# u2 = user('huyen', 'user')

# demo_func_require_admin_role(u1)
# demo_func_require_admin_role(u2)

# -------------------------------------------------task 2---->
# def timer():
#     def decorator(func):
#         def wrapper(*args, **kwargs):
#             start = time.time()
#             result = func(*args, **kwargs) #execute core conrern
#             end = time.time()
#             print(f'Function {func.__name__} completed run in {end - start}s')
#             return result
#         return wrapper
#     return decorator

# def debug(func):
#     def wrapper(*args, **kwargs):
#         print(f'Function start {func.__name__} ... {args}, {kwargs}.')
#         result = func(*args, **kwargs)
#         return result
#     return wrapper



# @timer()
# @debug
# def core_conrern_func_demo(args1, args2, args3):
#     time.sleep(2)

# core_conrern_func_demo('value1', 'value2', 'value3')



# ----------------------------- task 3----->
def thread_demo(arg):
    print(f'Function {__name__} ... started')
    time.sleep(2)
    print(f'Function {__name__} ... competed')
    
def thread_execute_demo():
    start = datetime.now()

    # thread_demo()
    # thread_demo()

    # t1 = threading.Thread(target=thread_demo, args=('arg1 value.',))
    # t2 = threading.Thread(target=thread_demo, args=('arg2 value.',))

    # t1.start()
    # t2.start()

    # t1.join(1000)
    # t2.join(1000)

    # p1 = multiprocessing.Process(target=thread_demo, args=('arg1 value',))
    # p2 = multiprocessing.Process(target=thread_demo, args=('arg2 value',))

    # p1.start()
    # p2.start()

    # p1.join(1000)
    # p2.join(1000)

    # - multi thread
    

    end = datetime.now()
    print(f'Completed process in {end - start}s')

# thread_execute_demo()


