import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent {
  updateCustomerForm! : FormGroup;

  id : number = this.activatedRoute.snapshot.params["id"];

  constructor(
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit() {
    this.updateCustomerForm = this.fb.group({
      name: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      phone: [null, [Validators.required]],
    });

    this.findCustomer();
  }

  findCustomer() {
    this.customerService.findCustomer(this.id).subscribe(
      (res) => {
        console.log(res)
        this.updateCustomerForm.patchValue(res);
      }
    )
  }

  onSubmit() {
    this.customerService.updateCustomer(this.id, this.updateCustomerForm.value)
      .subscribe((res) => {
        console.log(res)
        this.router.navigate(["/home"]);
      })
  }

  
}
