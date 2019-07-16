var prefix = ctx + "prod"

$(document).ready(function () {
    $('body').layout({west__size: 185});
    queryList();
});


function queryList() {
    var columns = [{
        checkbox: true
    },
        {
            field: 'prodId',
            title: '商品ID'
        },
        {
            field: 'prodName',
            title: '商品名称'
        },
        {
            field: 'skus',
            title: 'SKU信息',
            align: 'center',
            formatter: function (value, row, index) {
                console.info(value);
                var table = "<table>"
                for (i = 0; i < value.length; i++) {
                    table += '<tr><td>' + value[i].price + '</td><td>' + value[i].store + '</td><td>' + value[i].saled + '</td><td>' + value[i].freez + '</td></tr>';
                }
                table += '</table>';
                return table;

            }
        },
        {
            field: 'brandName',
            title: '品牌'
        },
        {
            field: 'createTime',
            title: '创建时间'
        },
        {
            field: 'lastUpdate',
            title: '修改时间'
        },
        {
            field: 'status',
            title: '状态',
            align: 'center',
            formatter: function (value, row, index) {
                if (value == '0') {
                    return '<span class="badge badge-primary">正常</span>';
                } else if (value == '1') {
                    return '<span class="badge badge-danger">禁用</span>';
                }
            }
        },
        {
            title: '操作',
            align: 'center',
            formatter: function (value, row, index) {
                var actions = [];
                actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="#" onclick="edit(\'' + row.userId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
                actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="#" onclick="remove(\'' + row.userId + '\')"><i class="fa fa-remove"></i>删除</a> ');
                return actions.join('');
            }
        }];
    var url = prefix + "/admin/list";
    $.initTableJsonParams(columns, url, queryParams);
}

function queryParams(params) {
    var param =
        {
            pageSize: params.limit,
            pageNum: params.offset / params.limit + 1,
            searchValue: params.search,
            orderByColumn: params.sort,
            isAsc: params.order,
        }
    return param;
}

/*用户管理-删除*/
function remove(userId) {
    $.modalConfirm("确定要删除选中用户吗？", function () {
        _ajax(prefix + "/" + userId, "", "delete");
    })
}

/*用户管理-修改*/
function edit(userId) {
    var url = prefix + '/edit/' + userId;
    layer_showAuto("修改用户", url);
}


/*查看-SKU*/
function add() {
    var url = prefix + '/add';
    layer_showAuto("新增用户", url);
}


/*用户管理-新增*/
function add() {
    var url = prefix + '/add';
    layer_showAuto("新增用户", url);
}

