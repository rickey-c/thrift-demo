namespace java com.rickey
namespace py com.rickey
struct User{
    1:i32 id,
    2:string name,
    3:i32 age = 0
}

service UserService{
    User getById(1:i32 id),
    bool isExist(1:string name)
}