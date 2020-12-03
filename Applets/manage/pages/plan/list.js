import { prefix, checkStore, domain, wxRequest } from '../../utils/util.js';
Page({
  data: {
    prefix,
    currentID: -1,
    ids: [],
    plans: [],
    slideButtons: {
      'false': {
        type: "default",
        text: '上架',
        extClass: 'default',
      }, 'true': {
        type: 'warn',
        text: '下架',
        extClass: 'warn',
      }
    },
    icons: {
      'false': 'clear',
      'true': 'success'
    }
  },

  onShow: function () {
    let { plans = [] } = this.data;
    if (plans.length === 0) {
      checkStore().then(({ authorization, info }) => {
        wxRequest({
          url: `${domain}/plans?sid=${info.sid}`,
          header: { authorization, info: JSON.stringify(info) },
        }).then(({ content }) => {
          console.log(content);
          this.setData(
            { plans: content }
          )
        })
      })
    }
  },

  bindShow: function (e) {
    this.setData({
      currentID: e.target.id
    });
    setTimeout(() => {
      this.setData({
        currentID: -1
      })
    }, 3000)
  },

  bindButtonTap: function (e) {
    wx.showModal({
      title: '警示',
      content: '请仔细审核商品信息！',
      success: (res) => {
        if (res.confirm) {
          checkStore().then(({ authorization, info }) => {
            const index = e.currentTarget.id;
            const { id, status } = this.data.plans[index];
            wxRequest({
              url: `${domain}/plans/${id}/updateStatus?sid=${info.sid}&status=${!status}`,
              method: 'PUT',
              header: { authorization, info: JSON.stringify(info) },
            }).then(({ content }) => {
              this.setData({
                [`plans[${index}].status`]: content
              })
            });
          })
        }
      }
    })
  },

  deletePlan: function (e) {
    wx.showModal({
      title: '警示',
      content: '是否删除商品?',
      success: (res) => {
        if (res.confirm) {
          checkStore().then(({ authorization, info }) => {
            const index = e.currentTarget.id;
            const { id } = this.data.plans[index];
            wxRequest({
              url: `${domain}/plans/${id}?sid=${info.sid}`,
              method: 'DELETE',
              header: { authorization, info: JSON.stringify(info) },
            }).then(() => {
              this.data.plans.splice(index, 1)
              this.setData({
                plans: this.data.plans
              })
            })
          })
        }
      }
    })
  },
  checkboxChange: function (e) {
    const key = e.currentTarget.id;
    this.setData({
      [key]: e.detail.value
    });
  },

  /**上架
   * 
   */
  up: function () {
    checkStore().then(({ authorization, info }) => {
      let { ids, plans } = this.data;
      plans.forEach((plan, index) => {
        if (ids.includes(plan.id)) {
          plans[index].status = true
        }
      });
      wxRequest({
        url: `${domain}/plans?sid=${info.sid}&ids=${ids}&status=true`,
        method: 'PUT',
        header: { authorization, info: JSON.stringify(info) },
      }).then(() => {
        this.setData({
          plans, ids: []
        })
      })
    })
  },
  /**下架
   * 
   */
  lower: function () {
    checkStore().then(({ authorization, info }) => {
      let { ids, plans } = this.data;
      plans.forEach((plan, index) => {
        if (ids.includes(plan.id)) {
          plans[index].status = false;
        }
      });
      wxRequest({
        url: `${domain}/plans?sid=${info.sid}&ids=${ids}&status=false`,
        method: 'PUT',
        header: { authorization, info: JSON.stringify(info) },
      }).then(() => {
        this.setData({
          plans, ids: []
        })
      })
    })
  },
  /**删除
   * 
   */
  delete: function () {
    checkStore().then(({ authorization, info }) => {
      let { ids, plans } = this.data;
      wxRequest({
        url: `${domain}/plans?sid=${info.sid}&ids=${ids}`,
        method: 'DELETE',
        header: { authorization, info: JSON.stringify(info) },
      }).then(() => {
        plans = this.data.plans.filter((value) => !ids.includes(value.id));
        this.setData({
          plans, ids: []
        })
      })
    })
  }
})